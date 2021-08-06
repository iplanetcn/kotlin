package com.phenix.task

import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.BiFunction
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Test
import task.task1
import task.task2
import task.task3
import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock

/**
 * TasksTest
 *
 * @author john
 * @since 2021-07-19
 */
class TasksTest {
    @Volatile
    var cnt = 2


    @Test
    internal fun test_join() {
        lateinit var s1: String
        lateinit var s2: String

        val t1 = Thread { s1 = task1() }
        val t2 = Thread { s2 = task2() }
        t1.start()
        t2.start()

        t1.join()
        t2.join()

        task3(s1, s2)
    }

    @Test
    internal fun test_synchronized() {
        lateinit var s1: String
        lateinit var s2: String

        Thread {
            synchronized(Unit) {
                s1 = task1()
            }
        }.start()
        s2 = task2()

        synchronized(Unit) {
            task3(s1, s2)
        }
    }

    @Test
    internal fun test_ReentrantLock() {
        lateinit var s1: String
        lateinit var s2: String

        val lock = ReentrantLock()
        Thread {
            lock.lock()
            s1 = task1()
            lock.unlock()
        }.start()
        s2 = task2()

        lock.lock()
        task3(s1, s2)
        lock.unlock()
    }

    @Test
    internal fun test_blockingQueue() {
        lateinit var s1: String
        lateinit var s2: String

        val queue = SynchronousQueue<Unit>()
        Thread {
            s1 = task1()
            queue.put(Unit)
        }.start()

        s2 = task2()

        queue.take()
        task3(s1, s2)
    }

    @Test
    internal fun test_CountDownLatch() {
        lateinit var s1: String
        lateinit var s2: String
        val cd = CountDownLatch(2)
        Thread() {
            s1 = task1()
            cd.countDown()
        }.start()

        Thread() {
            s2 = task2()
            cd.countDown()
        }.start()

        cd.await()
        task3(s1, s2)
    }

    /**
     * <p>CyclicBarrier 是 JUC 提供的另一种共享锁机制，它可以让一组线程到达一个同步点后再一起继续运行，其中任意一个线程未达到同步点，其他已到达的线程均会被阻塞。
     * <p>与 CountDownLatch 的区别在于 CountDownLatch 是一次性的，而 CyclicBarrier 可以被重置后重复使用，这也正是 Cyclic 的命名由来，可以循环使用
     */
    @Test
    internal fun test_CyclicBarrier() {
        lateinit var s1: String
        lateinit var s2: String
        val cb = CyclicBarrier(3)
        Thread {
            s1 = task1()
            cb.await()
        }.start()

        Thread {
            s2 = task1()
            cb.await()
        }.start()

        cb.await()
        task3(s1, s2)

    }

    /**
     * AQS 内部通过自旋锁实现同步，自旋锁的本质是利用 CompareAndSwap 避免线程阻塞的开销。 因此，我们可以使用基于 CAS 的原子类计数，达到实现无锁操作的目的。
     */
    @Test
    internal fun test_Cas() {
        lateinit var s1: String
        lateinit var s2: String

        val cas = AtomicInteger(2)
        Thread {
            s1 = task1()
            cas.getAndDecrement()
        }.start()

        Thread {
            s2 = task2()
            cas.getAndDecrement()
        }.start()

        // While 循环空转看起来有些浪费资源，但是自旋锁的本质就是这样，所以 CAS 仅仅适用于一些cpu密集型的短任务同步。
        while (cas.get() != 0) {
            //no op
        }

        task3(s1, s2)
    }

    /**
     * 看到 CAS 的无锁实现，也许很多人会想到 volatile， 是否也能实现无锁的线程安全？
     * <p> 注意，这种写法是错误的 volatile 能保证可见性，但是不能保证原子性，cnt-- 并非线程安全，需要加锁操作
     */
    @Test
    internal fun test_Volatile() {
        lateinit var s1: String
        lateinit var s2: String

        Thread {
            s1 = task1()
            cnt--
        }.start()

        Thread {
            s2 = task2()
            cnt--
        }.start()

        while (cnt != 0) {
            // noop
        }

        task3(s1, s2)
    }

    @Test
    internal fun test_Future() {
        val future1 = FutureTask { task1() }
        val future2 = FutureTask { task2() }

        Executors.newCachedThreadPool().execute(future1)
        Executors.newCachedThreadPool().execute(future2)

        task3(future1.get(), future2.get())
    }

    @Test
    internal fun test_CompletableFuture() {
        CompletableFuture.supplyAsync(task1)
            .thenCombine(CompletableFuture.supplyAsync(task2)) { p1, p2 ->
                task3(p1, p2)
            }.join()
    }

    @Test
    internal fun test_RxJava() {
        Observable.zip(
            Observable.fromCallable(task1).subscribeOn(Schedulers.newThread()),
            Observable.fromCallable(task2).subscribeOn(Schedulers.newThread()),
            BiFunction(task3)
        ).test().await()
    }

    @Test
    internal fun test_Coroutine() {
        runBlocking {
            val c1 = async(Dispatchers.IO) { task1() }
            val c2 = async(Dispatchers.IO) { task2() }

            task3(c1.await(), c2.await())
        }
    }

    @Test
    internal fun test_Flow() {
        val flow1 = flow { emit(task1()) }
        val flow2 = flow { emit(task2()) }

        runBlocking {
            flow1.zip(flow2) { t1, t2 -> task3(t1, t2) }
                .flowOn(Dispatchers.IO)
                .collect()
        }
    }
}