package learn

/**
 * AnonymousObject
 * 匿名对象只能用在本地 ( 函数 ) 或 private 声明中。
 * 如果将匿名对象用于 public 函数的返回值，或  public 属性的类型，那么 Kotlin 编译器会将这些函数或属性的返回类型重新定义为匿名对象的父类型，
 * 如果匿名对象没有实现任何接口，也没有从任何类继承，那么父类型就是 Any 。因此，添加在匿名对象中的任何成员都将无法访问。
 *
 * @author john
 * @since 2021-12-17
 */
class AnonymousObject {
    // private 函数,返回类型是匿名对象本身,可以访问x
    private fun foo1() = object {
        var x: String = "x"
    }

    //public 函数,由于匿名对象没有任何父类型,因此函数的返回类型是 Any
    fun foo2() = object {
        var y: String = "y"
    }

    fun bar(){
        // 可以访问
        var x = foo1().x
        // 编译错误,因为 publicFoo public 方法,返回类型是 Any
//        var y = foo2().y
    }


}