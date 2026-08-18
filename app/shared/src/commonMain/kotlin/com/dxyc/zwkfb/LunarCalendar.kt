package com.dxyc.zwkfb

import kotlin.math.floor
import kotlin.math.sin
import kotlin.math.PI

/**
 * 纯 Kotlin 农历计算工具（基于 Ho Ngoc Duc 天文算法）
 * 全平台兼容：Android / iOS / Desktop / Web
 */
object LunarCalendar {

    private const val TIME_ZONE = 8.0 // 中国标准时间 UTC+8

    private val LUNAR_MONTH_NAMES = listOf(
        "正月", "二月", "三月", "四月", "五月", "六月",
        "七月", "八月", "九月", "十月", "冬月", "腊月"
    )

    private val LUNAR_DAY_NAMES = listOf(
        "初一", "初二", "初三", "初四", "初五", "初六", "初七", "初八", "初九", "初十",
        "十一", "十二", "十三", "十四", "十五", "十六", "十七", "十八", "十九", "二十",
        "廿一", "廿二", "廿三", "廿四", "廿五", "廿六", "廿七", "廿八", "廿九", "三十"
    )

    private val ZODIAC_ANIMALS = listOf(
        "鼠", "牛", "虎", "兔", "龙", "蛇",
        "马", "羊", "猴", "鸡", "狗", "猪"
    )

    private val HEAVENLY_STEMS = listOf("甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸")
    private val EARTHLY_BRANCHES = listOf("子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥")

    data class LunarDate(
        val year: Int,
        val month: Int,
        val day: Int,
        val isLeapMonth: Boolean
    ) {
        /** 农历月份中文名称，如 "正月"、"腊月" */
        fun monthName(): String = (if (isLeapMonth) "闰" else "") + LUNAR_MONTH_NAMES[month - 1]

        /** 农历日期中文名称，如 "初一"、"十五" */
        fun dayName(): String = LUNAR_DAY_NAMES.getOrElse(day - 1) { "$day" }

        /** 生肖，如 "龙" */
        fun zodiac(): String = ZODIAC_ANIMALS[(year - 4) % 12]

        /** 干支纪年，如 "甲辰" */
        fun ganZhiYear(): String {
            val stem = HEAVENLY_STEMS[(year - 4) % 10]
            val branch = EARTHLY_BRANCHES[(year - 4) % 12]
            return "$stem$branch"
        }

        override fun toString(): String = "${year}年${monthName()}${dayName()}"
    }

    /**
     * 公历转农历
     * @param year 公历年
     * @param month 公历月 (1-12)
     * @param day 公历日
     */
    fun solarToLunar(year: Int, month: Int, day: Int): LunarDate {
        val result = convertSolar2Lunar(day, month, year, TIME_ZONE)
        return LunarDate(
            year = result[2],
            month = result[1],
            day = result[0],
            isLeapMonth = result[3] == 1
        )
    }

    /**
     * 获取某年某月的农历新年（春节）对应的公历日期
     */
    fun lunarNewYear(year: Int): Triple<Int, Int, Int> {
        // 农历正月初一对应的公历日期
        val result = convertLunar2Solar(1, 1, year, 0, TIME_ZONE)
        return Triple(result[2], result[1], result[0]) // year, month, day
    }

    // ==================== 天文算法核心（Ho Ngoc Duc） ====================

    private fun jdFromDate(dd: Int, mm: Int, yy: Int): Int {
        val a = (14 - mm) / 12
        val y = yy + 4800 - a
        val m = mm + 12 * a - 3
        var jd = dd + (153 * m + 2) / 5 + 365 * y + y / 4 - y / 100 + y / 400 - 32045
        if (jd < 2299161) {
            jd = dd + (153 * m + 2) / 5 + 365 * y + y / 4 - 32083
        }
        return jd
    }

    private fun jdToDate(jd: Int): IntArray {
        val a: Int
        val b: Int
        val c: Int
        if (jd > 2299160) {
            a = jd + 32044
            b = (4 * a + 3) / 146097
            c = a - b * 146097 / 4
        } else {
            b = 0
            c = jd + 32082
        }
        val d = (4 * c + 3) / 1461
        val e = c - 1461 * d / 4
        val m = (5 * e + 2) / 153
        val day = e - (153 * m + 2) / 5 + 1
        val month = m + 3 - 12 * (m / 10)
        val year = b * 100 + d - 4800 + m / 10
        return intArrayOf(day, month, year)
    }

    private fun sunLongitude(jdn: Double): Double = sunLongitudeAA98(jdn)

    private fun sunLongitudeAA98(jdn: Double): Double {
        val julianTime = (jdn - 2451545.0) / 36525
        val squareJulianTime = julianTime * julianTime
        val dr = PI / 180
        val meanAnomaly = 357.52910 + 35999.05030 * julianTime - 0.0001559 * squareJulianTime - 0.00000048 * julianTime * squareJulianTime
        val meanLongitude = 280.46645 + 36000.76983 * julianTime + 0.0003032 * squareJulianTime
        var dl = (1.914600 - 0.004817 * julianTime - 0.000014 * squareJulianTime) * sin(dr * meanAnomaly)
        dl += (0.019993 - 0.000101 * julianTime) * sin(dr * 2 * meanAnomaly) + 0.000290 * sin(dr * 3 * meanAnomaly)
        var trueLongitude = meanLongitude + dl
        trueLongitude -= 360 * floor(trueLongitude / 360)
        return trueLongitude
    }

    private fun newMoon(k: Int): Double = newMoonAA98(k)

    private fun newMoonAA98(k: Int): Double {
        val julianTime = k / 1236.85
        val squareJulianTime = julianTime * julianTime
        val cubicJulianTime = squareJulianTime * julianTime
        val dr = PI / 180
        var jd1 = 2415020.75933 + 29.53058868 * k + 0.0001178 * squareJulianTime - 0.000000155 * cubicJulianTime
        jd1 += 0.00033 * sin((166.56 + 132.87 * julianTime - 0.009173 * squareJulianTime) * dr)
        val sunMeanAnomaly = 359.2242 + 29.10535608 * k - 0.0000333 * squareJulianTime - 0.00000347 * cubicJulianTime
        val moonMeanAnomaly = 306.0253 + 385.81691806 * k + 0.0107306 * squareJulianTime + 0.00001236 * cubicJulianTime
        val f = 21.2964 + 390.67050646 * k - 0.0016528 * squareJulianTime - 0.00000239 * cubicJulianTime
        var c1 = (0.1734 - 0.000393 * julianTime) * sin(sunMeanAnomaly * dr) + 0.0021 * sin(2 * dr * sunMeanAnomaly)
        c1 = c1 - 0.4068 * sin(moonMeanAnomaly * dr) + 0.0161 * sin(dr * 2 * moonMeanAnomaly)
        c1 -= 0.0004 * sin(dr * 3 * moonMeanAnomaly)
        c1 = c1 + 0.0104 * sin(dr * 2 * f) - 0.0051 * sin(dr * (sunMeanAnomaly + moonMeanAnomaly))
        c1 = c1 - 0.0074 * sin(dr * (sunMeanAnomaly - moonMeanAnomaly)) + 0.0004 * sin(dr * (2 * f + sunMeanAnomaly))
        c1 = c1 - 0.0004 * sin(dr * (2 * f - sunMeanAnomaly)) - 0.0006 * sin(dr * (2 * f + moonMeanAnomaly))
        c1 += 0.0010 * sin(dr * (2 * f - moonMeanAnomaly)) + 0.0005 * sin(dr * (2 * moonMeanAnomaly + sunMeanAnomaly))
        val deltAt = if (julianTime < -11) {
            0.001 + 0.000839 * julianTime + 0.0002261 * squareJulianTime - 0.00000845 * cubicJulianTime - 0.000000081 * julianTime * cubicJulianTime
        } else {
            -0.000278 + 0.000265 * julianTime + 0.000262 * squareJulianTime
        }
        return jd1 + c1 - deltAt
    }

    private fun floorInt(d: Double): Int = floor(d).toInt()

    private fun getSunLongitude(dayNumber: Int, timeZone: Double): Double {
        return sunLongitude(dayNumber - 0.5 - timeZone / 24)
    }

    private fun getNewMoonDay(k: Int, timeZone: Double): Int {
        val jd = newMoon(k)
        return floorInt(jd + 0.5 + timeZone / 24)
    }

    private fun getLunarMonth11(yy: Int, timeZone: Double): Int {
        val off = jdFromDate(31, 12, yy) - 2415021.076998695
        val k = floorInt(off / 29.530588853)
        var nm = getNewMoonDay(k, timeZone)
        val sunLong = floorInt(getSunLongitude(nm, timeZone) / 30)
        if (sunLong >= 9) {
            nm = getNewMoonDay(k - 1, timeZone)
        }
        return nm
    }

    private fun getLeapMonthOffset(a11: Int, timeZone: Double): Int {
        val k = floorInt(0.5 + (a11 - 2415021.076998695) / 29.530588853)
        var last: Int
        var i = 1
        var arc = floorInt(getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone) / 30)
        do {
            last = arc
            i++
            arc = floorInt(getSunLongitude(getNewMoonDay(k + i, timeZone), timeZone) / 30)
        } while (arc != last && i < 14)
        return i - 1
    }

    private fun convertSolar2Lunar(dd: Int, mm: Int, yy: Int, timeZone: Double): IntArray {
        val dayNumber = jdFromDate(dd, mm, yy)
        val k = floorInt((dayNumber - 2415021.076998695) / 29.530588853)
        var monthStart = getNewMoonDay(k + 1, timeZone)
        if (monthStart > dayNumber) {
            monthStart = getNewMoonDay(k, timeZone)
        }
        var a11 = getLunarMonth11(yy, timeZone)
        var b11 = a11
        var lunarYear: Int
        if (a11 >= monthStart) {
            lunarYear = yy
            a11 = getLunarMonth11(yy - 1, timeZone)
        } else {
            lunarYear = yy + 1
            b11 = getLunarMonth11(yy + 1, timeZone)
        }
        val lunarDay = dayNumber - monthStart + 1
        val diff = floorInt((monthStart - a11) / 29.0)
        var lunarLeap = 0
        var lunarMonth = diff + 11
        if (b11 - a11 > 365) {
            val leapMonthDiff = getLeapMonthOffset(a11, timeZone)
            if (diff >= leapMonthDiff) {
                lunarMonth = diff + 10
                if (diff == leapMonthDiff) {
                    lunarLeap = 1
                }
            }
        }
        if (lunarMonth > 12) {
            lunarMonth -= 12
        }
        if (lunarMonth >= 11 && diff < 4) {
            lunarYear -= 1
        }
        return intArrayOf(lunarDay, lunarMonth, lunarYear, lunarLeap)
    }

    private fun convertLunar2Solar(
        lunarDay: Int, lunarMonth: Int, lunarYear: Int, lunarLeap: Int, timeZone: Double
    ): IntArray {
        val a11: Int
        val b11: Int
        if (lunarMonth < 11) {
            a11 = getLunarMonth11(lunarYear - 1, timeZone)
            b11 = getLunarMonth11(lunarYear, timeZone)
        } else {
            a11 = getLunarMonth11(lunarYear, timeZone)
            b11 = getLunarMonth11(lunarYear + 1, timeZone)
        }
        val k = floorInt(0.5 + (a11 - 2415021.076998695) / 29.530588853)
        var off = lunarMonth - 11
        if (off < 0) {
            off += 12
        }
        if (b11 - a11 > 365) {
            val leapOff = getLeapMonthOffset(a11, timeZone)
            var leapMonth = leapOff - 2
            if (leapMonth < 0) {
                leapMonth += 12
            }
            if (lunarLeap != 0 && lunarMonth != leapMonth) {
                return intArrayOf(0, 0, 0)
            } else if (lunarLeap != 0 || off >= leapOff) {
                off += 1
            }
        }
        val monthStart = getNewMoonDay(k + off, timeZone)
        return jdToDate(monthStart + lunarDay - 1)
    }
}