package demos.android.read.write.internal.file.demo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.io.File

class MainActivity : AppCompatActivity() {

    private val file by lazy {
        File(filesDir, "demo.txt").apply {
            this.writeText("Hello from file")
        }
    }

    private val filePath by lazy<TextView> { findViewById(R.id.filePath) }
    private val fileContent by lazy<TextView> { findViewById(R.id.fileContent) }
    private val modifyButton by lazy<Button> { findViewById(R.id.modifyButton) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        filePath.text = file.absolutePath
        showFileContent()
        setupModifyButton()
    }

    private fun setupModifyButton() {
        modifyButton.setOnClickListener { _ ->
            file.appendText(" (modified)")
            showFileContent()
        }
    }

    private fun showFileContent() {
        fileContent.text = file.readText()
    }

}
