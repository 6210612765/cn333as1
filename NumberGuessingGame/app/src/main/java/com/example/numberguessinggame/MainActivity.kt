package com.example.numberguessinggame

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random.Default.nextInt

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var editText: EditText
    lateinit var imageButtonReset: ImageButton
    lateinit var imageButtonCheck: ImageButton

    var random: Int = nextInt(1,1000)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        editText = findViewById(R.id.editText)
        imageButtonReset = findViewById(R.id.imageButtonReset)
        imageButtonCheck = findViewById(R.id.imageButtonCheck)

        textView.text = "Please Enter your number(1-1000)"

        var count: Int = 0
        var percentage: Float = 1F

        var min: Int = 1
        var max: Int = 1000

        imageButtonCheck.setOnClickListener{

            val number: Int = editText.text.toString().toInt()

            if(number < random){
                min  = number
                textView.text = "that's the wrong number! (too low), \nnumber is between($min,$max)"
                editText.text.clear()
                count += 1
            }
            else if(number > random){
                max = number
                textView.text = "that's the wrong number! (too high), \nnumber is between($min,$max)"
                editText.text.clear()
                count += 1
            }
            else{
                percentage = percentage.div(count+1)*100
                textView.text = "Congratulation, it's your lucky day , Total try : $count" +
                        "\nAccuracy percentage is $percentage%"
                editText.text.clear()
                count = 0
                percentage = 1F
                min = 1
                max = 1000
            }
        }

        imageButtonReset.setOnClickListener{

            reset()
        }

    }

    fun reset(){

        random = nextInt(1,1000)
        textView.text = "Please Enter your number"
        editText.text.clear()
    }
 }


