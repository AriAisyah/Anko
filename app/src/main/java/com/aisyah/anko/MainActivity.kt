package com.aisyah.anko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.design.snackbar
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //nge-set main ui jadi layout MainActivity.kt
        MainUI().setContentView(this)

        //toast dengan anko commons
        toast("ini toast")

    }

    class MainUI : AnkoComponent<MainActivity> {
        override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
            linearLayout {
                orientation = LinearLayout.VERTICAL
                backgroundColor = R.color.bg

                textView("This is korean food, it is looks delicious, isnt it?")

                imageView(R.drawable.food).lparams(width = matchParent, height = dip(200))

                button("can i ask something?") {
                    onClick {
                        alert("have you eaten?") {
                            positiveButton("yah") {
                                toast("i hope you won't get fat")
                            }
                            negativeButton("nah") {
                                toast("you aren't on a diet, are you?")
                            }
                        }.show()
                    }
                }

                button("progress") {
                    onClick {
                        //snackbar("ini snackbar")

                        indeterminateProgressDialog("please wait. . .").show()
                    }
                }

                button("intent") {
                    onClick {
                        //intent
                        startActivity<Main2Activity>()
                    }
                }
            }
        }

    }
}
