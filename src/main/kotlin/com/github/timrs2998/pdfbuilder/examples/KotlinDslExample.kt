package com.github.timrs2998.pdfbuilder.examples

import com.github.timrs2998.pdfbuilder.document
import com.github.timrs2998.pdfbuilder.header
import com.github.timrs2998.pdfbuilder.row
import com.github.timrs2998.pdfbuilder.style.Border
import com.github.timrs2998.pdfbuilder.style.Margin
import com.github.timrs2998.pdfbuilder.style.Padding
import com.github.timrs2998.pdfbuilder.table
import com.github.timrs2998.pdfbuilder.text
import org.apache.pdfbox.pdmodel.font.PDType1Font
import java.awt.Color

/**
 * Class containing main method to demonstrate creation of a sample "output.pdf"
 * using a Kotlin-specific DSL. This approach is more declarative, but is less
 * portable between languages.
 */
object KotlinDslExample {

  @JvmStatic
  fun main(args: Array<String>) {
    document {
      padding = Padding(50f, 50f, 50f, 50f)

      text("Hello")

      text("Hello, color is red!") {
        fontColor = Color(1f, .1f, .1f)
      }

      table {
        border = Border(1f, 2f, 3f, 4f, Color.GREEN, Color.RED, Color.BLUE, Color.BLACK)
        margin = Margin(25f, 0f, 25f, 0f)

        header {
          backgroundColor = Color.CYAN
          pdFont = PDType1Font.TIMES_BOLD

          text("First Column")
          text("Second Column")
        }

        for (i in IntRange(0, 60)) {
          row {
            text("row #$i, col 0")
            text("row #$i, col 1")
          }
        }
      }

      text("Hola, mundo.")
    }.use { pdDocument ->
      pdDocument.save("output.pdf")
    }
  }

}
