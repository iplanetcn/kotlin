
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import java.awt.Dimension
import javax.swing.JFrame
import javax.swing.JLabel

//*****************************************************
// 全局函数
//*****************************************************

/**
 * 显示GUI
 */
fun showGUI() {
    createGUI().isVisible = true
}

/**
 * 创建GUI。出于线程安全的考虑，
 * 这个方法在事件调用线程中调用。
 */
fun createGUI(): JFrame {
    // 确保一个漂亮的外观风格
    JFrame.setDefaultLookAndFeelDecorated(true)
    // 创建及设置窗口
    val frame = JFrame("Swing")
    frame.preferredSize = Dimension(300, 200)
    frame.defaultCloseOperation = JFrame.EXIT_ON_CLOSE
    // 添加标签
    val label = JLabel("Label")
    frame.contentPane.add(label)
    // 显示窗口
    frame.pack()
    return frame
}


/**
 * 等待2秒
 */
suspend fun stallForTime() {
    withContext(Dispatchers.Default) {
        delay(2000)
    }
}

