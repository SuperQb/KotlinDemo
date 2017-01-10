package com.qb.kotlindemo.model1

import android.content.Context
import android.util.Log
import android.widget.ImageView
import android.widget.Toast

/**
 * Created by qubo on 2017/1/10.
 */

/**
 * JavaBean
 */
data class Data(@JvmField var a: String) {
    init {
        Log.i("MainActivity", "init")
    }

    fun printA() {
        Log.i("MainActivity", "hello" + a)
    }
}

/**
 * 单例
 */
object Singleton {
    var a = 0
    fun printHello() {
        a++
        Log.i("MainActivity", "hello" + a)
    }
}

/**
 * 重载
 */
class OverLoad {
    fun overLoad(a: Int, b: Int = 1, c: Int = 2) {
        Log.i("MainActivity", a.toString() + b.toString() + c.toString())
    }

    @JvmOverloads
    fun overLoadJava(a: Int, b: Int = 1, c: Int = 2) {
        Log.i("MainActivity", a.toString() + b.toString() + c.toString())
    }
}

/**
 * 包方法,限制的范围
 */
fun printHello() {
    Log.i("MainActivity", "hello package")
}
fun packageHello() {
    Log.i("MainActivity", "hello package")
}

/**
 * 拓展方法
 */
fun String.notEmpty(): Boolean {
    return this != ""
}

internal class InternalClass {
    fun printHello() {
        Log.i("MainActivity", "hello internal")
    }
}

/**
 * 拓展方法
 */
@JvmOverloads
fun Context.toast(message: String, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, message, length).show()
}

fun Context.printHello() {
    Toast.makeText(this, "hello", Toast.LENGTH_SHORT).show()
}

fun ImageView.setIcon() {
    this.setImageResource(com.qb.kotlindemo.R.mipmap.ic_launcher)
}

/**
 * 特殊JavaBean
 */
data class DataS(var a: String) {
    fun printA() {
        Log.i("MainActivity", "hello" + a)
    }
}

/**
 * 多个构造参数
 */
class DataM {
    var a: String = "1"

    constructor(a: String) {
        this.a = a
    }

    constructor()

    fun printA() {
        Log.i("MainActivity", "hello" + a)
    }
}

/**
 * 伴生对象
 */
class CompanionObject {
    var name: String = "qubo"

    companion object {
        fun getName(): String {
            return "test"
        }
    }
}

data class JsonData(var a: Data)


data class AppThemeBean(var mainPage: MainPageBean, var titlebar: TitlebarBean) {
    data class MainPageBean(var tabbar: TabbarBean) {
        data class TabbarBean(var textColors: TextColorsBean, var bg: String, var icons: List<IconsBean>) {
            data class TextColorsBean(var normal: String, var selected: String)
            data class IconsBean(var normal: String, var selected: String)
        }
    }

    data class TitlebarBean(var bg: String, var textColors: TextColorsBean) {
        data class TextColorsBean(var normal: String, var selected: String, var subtext: String)
    }
}
