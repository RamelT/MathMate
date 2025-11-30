package com.example.mlmtest1_721.ui.conicsections

import kotlin.math.abs
import kotlin.math.sqrt

fun circle (a : Double, b : Double, c : Double, d : Double, e : Double) {
    val h = 0-(b / (2 * a))
    val k = 0-(d / (2 * c))
    val rr = (((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * a))) / a)

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)
    val rrF = doubleToFraction(rr)
    val rF = doubleToFraction(sqrt(rr))

    val h1 : String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1 : String = if (k > 0) {
        " - $kF"
    } else if  (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }


    if (rr < 0) {
        appendBigBoldResult("That is not a conic section!\n")
    } else {
        appendBigBoldResult("That is a circle!\n\n")

        appendNormalResult("Standard form:\n")
        appendBigBlueBoldResult("(x$h1)² + (y$k1)² = $rrF\n\n")

        appendNormalResult("Center:\n")
        appendBigBlueBoldResult("($hF, $kF)\n\n")

        appendNormalResult("Radius:\n")
        appendBigBlueBoldResult("sqrt($rrF) = $rF units\n\n")
    }
    explainCircle(a, b, c, d, e)
}

fun parabola(a: Double, b: Double, c: Double, d: Double, e: Double) {
    if ((a == 0.0 && b == 0.0) || (c == 0.0 && d == 0.0)) {
        result.append("That is not a conic section!\n")
    } else {
        if (c == 0.0) {
            if (d / a > 0) { // down
                parabolaDown(a, b, d, e)
            } else { // up
                parabolaUp(a, b, d, e)
            }
        } else {
            if (b / c > 0) { // left
                parabolaLeft(b, c, d, e)
            } else { // right
                parabolaRight(b, c, d, e)
            }
        }
    }
}

fun parabolaDown(a: Double, b: Double, d: Double, e: Double) {
    val h = 0 - (b / (2 * a))
    val k = ((0 - e) / d) + ((b * b) / (4 * a * d))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = d / a
    val p = a4 / 4

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)

    val h1 : String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1 : String = if (k > 0) {
        " - $kF"
    } else if  (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldResult("That is a parabola!\n")

    appendNormalResult("The parabola opens downward\n\n")

    appendNormalResult("Standard form:\n")
    appendBigBlueBoldResult("(x$h1)² = -${doubleToFraction(a4)}(y$k1)\n\n")

    appendNormalResult("Vertex:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Focus:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - p)})\n\n")

    appendNormalResult("Axis of symmetry:\n")
    appendBigBlueBoldResult("x = ${doubleToFraction(cleanh)}\n\n")

    appendNormalResult("Equation of directrix:\n")
    appendBigBlueBoldResult("y = ${doubleToFraction(cleank + p)}\n\n")

    appendNormalResult("Length of latus rectum:\n")
    appendBigBlueBoldResult("${doubleToPositiveFraction(a4)} units\n\n")

    appendNormalResult("Ends of latus rectum:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh - (2 * p))}, ${doubleToFraction(cleank - p)}) and (${doubleToFraction(cleanh + (2 * p))}, ${doubleToFraction(cleank - p)})\n\n")

    explainParabolaDown(a, b, d, e)
}

fun parabolaUp(a: Double, b: Double, d: Double, e: Double) {
    val h = 0 - (b / (2 * a))
    val k =((0 - e) / d) + ((b * b) / (4 * a * d))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = (0-d) / a
    val p = a4 / 4

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)

    val h1 : String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1 : String = if (k > 0) {
        " - $kF"
    } else if  (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldResult("That is a parabola!\n")

    appendNormalResult("The parabola opens upward\n\n")

    appendNormalResult("Standard form:\n")
    appendBigBlueBoldResult("(x$h1)² = ${doubleToFraction(a4)}(y$k1)\n\n")

    appendNormalResult("Vertex:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Focus:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + p)})\n\n")

    appendNormalResult("Axis of symmetry:\n")
    appendBigBlueBoldResult("x = ${doubleToFraction(cleanh)}\n\n")

    appendNormalResult("Equation of directrix:\n")
    appendBigBlueBoldResult("y = ${doubleToFraction(cleank - p)}\n\n")

    appendNormalResult("Length of latus rectum:\n")
    appendBigBlueBoldResult("${doubleToPositiveFraction(a4)} units\n\n")

    appendNormalResult("Ends of latus rectum:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh - (2 * p))}, ${doubleToFraction(cleank + p)}) and (${doubleToFraction(cleanh + (2 * p))}, ${doubleToFraction(cleank + p)})\n\n")

    explainParabolaUp(a, b, d, e)
}

fun parabolaLeft(b: Double, c: Double, d: Double, e: Double) {
    val k = 0 - (d / (2 * c))
    val h = ((0 - e) / b) + ((d * d) / (4 * c * b))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = b / c
    val p = a4 / 4

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)

    val h1 : String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1 : String = if (k > 0) {
        " - $kF"
    } else if  (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldResult("That is a parabola!\n")

    appendNormalResult("The parabola opens to the left\n\n")

    appendNormalResult("Standard form:\n")
    appendBigBlueBoldResult("(y$k1)² = -${doubleToFraction(a4)}(x$h1)\n\n")

    appendNormalResult("Vertex:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Focus:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh - p)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Axis of symmetry:\n")
    appendBigBlueBoldResult("y = ${doubleToFraction(cleank)}\n\n")

    appendNormalResult("Equation of directrix:\n")
    appendBigBlueBoldResult("x = ${doubleToFraction(cleanh + p)}\n\n")

    appendNormalResult("Length of latus rectum:\n")
    appendBigBlueBoldResult("${doubleToPositiveFraction(a4)} units\n\n")

    appendNormalResult("Ends of latus rectum:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh - p)}, ${doubleToFraction(cleank - (2 * p))}) and (${doubleToFraction(cleanh - p)}, ${doubleToFraction(cleank + (2 * p))})\n\n")

    explainParabolaLeft(b, c, d, e)
}

fun parabolaRight(b: Double, c: Double, d: Double, e: Double) {
    val k = 0 - (d / (2 * c))
    val h = ((0 - e) / b) + ((d * d) / (4 * c * b))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = (0 - b) / c
    val p = a4 / 4

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)

    val h1 : String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1 : String = if (k > 0) {
        " - $kF"
    } else if  (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldResult("That is a parabola!\n")

    appendNormalResult("The parabola opens to the right\n\n")

    appendNormalResult("Standard form:\n")
    appendBigBlueBoldResult("(y$k1)² = ${doubleToFraction(a4)}(x$h1)\n\n")

    appendNormalResult("Vertex:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Focus:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh + p)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Axis of symmetry:\n")
    appendBigBlueBoldResult("y = ${doubleToFraction(cleank)}\n\n")

    appendNormalResult("Equation of directrix:\n")
    appendBigBlueBoldResult("x = ${doubleToFraction(cleanh - p)}\n\n")

    appendNormalResult("Length of latus rectum:\n")
    appendBigBlueBoldResult("${doubleToPositiveFraction(a4)} units\n\n")

    appendNormalResult("Ends of latus rectum:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh + p)}, ${doubleToFraction(cleank - (2 * p))}) and (${doubleToFraction(cleanh + p)}, ${doubleToFraction(cleank + (2 * p))})\n\n")

    explainParabolaRight(b, c, d, e)
}

fun ellipse(a: Double, b: Double, c: Double, d: Double, e: Double) {
    if ((((0-e)+((b*b)/(4*a))+((d*d)/(4*c)))/a)<0 || (((0-e)+((b*b)/(4*a))+((d*d)/(4*c)))/c)<0) {
        result.append("That is not a conic section!")
    }
    else {
        if (((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * c))) / a > ((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * c))) / c) {
            ellipseHorizontal(a, b, c, d, e) // horizontal
        } else {
            ellipseVertical(a, b, c, d, e) // vertical
        }
    }
}

fun ellipseVertical(a: Double, b: Double, c: Double, d: Double, e: Double) {
    val h = 0 - (b / (2 * a))
    val k = 0 - (d / (2 * c))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val aa = ((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * c))) / c
    val bb = ((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * c))) / a
    val aNew = sqrt(aa)
    val bNew = sqrt(bb)
    val cNew = sqrt(aa - bb)
    val eNew = c / a
    val d1 = k + (a / e)
    val d2 = k - (a / e)
    val latusRectumLength = (2 * b * b) / a
    val lrXP = h + (b * b) / a
    val lrXN = h - (b * b) / a
    val lrYP = k + c
    val lrYN = k - c

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)

    val h1 : String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1 : String = if (k > 0) {
        " - $kF"
    } else if  (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldResult("That is an ellipse!\n\n")

    appendNormalResult("Standard form:\n")
    appendBigBlueBoldResult("(x$h1)²/(${doubleToFraction(bb)}) + (y$k1)²/(${doubleToFraction(aa)}) = 1\n\n")

    appendNormalResult("Center:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Major axis:\n")
    appendBigBlueBoldResult("Vertical, x = ${doubleToFraction(cleanh)}\n\n")

    appendNormalResult("Vertices:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + aNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - aNew)})\n\n")

    appendNormalResult("Co-vertices:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh + bNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - bNew)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Foci:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + cNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - cNew)})\n\n")

    appendNormalResult("Directrices:\n")
    appendBigBlueBoldResult("y = ${doubleToFraction(d1)} and y = ${doubleToFraction(d2)}\n\n")

    appendNormalResult("Length of latera recta:\n")
    appendBigBlueBoldResult("${doubleToFraction(latusRectumLength)} units\n\n")

    appendNormalResult("Endpoints of latera recta:\n")
    appendBigBlueBoldResult(
        "(${doubleToFraction(lrXP)}, ${doubleToFraction(lrYP)}), " +
                "(${doubleToFraction(lrXP)}, ${doubleToFraction(lrYN)}), " +
                "(${doubleToFraction(lrXN)}, ${doubleToFraction(lrYP)}), " +
                "(${doubleToFraction(lrXN)}, ${doubleToFraction(lrYN)})\n\n"
    )

    appendNormalResult("Values of a, b, c:\n")
    appendBigBlueBoldResult("a = ${doubleToFraction(aNew)}, b = ${doubleToFraction(bNew)}, c = ${doubleToFraction(cNew)}\n\n")

    appendNormalResult("Values of e and d:\n")
    appendBigBlueBoldResult("e = ${doubleToFraction(eNew)}, d = ${doubleToFraction(d1)}\n\n")

    explainEllipseVertical(a, b, c, d, e)
}

fun ellipseHorizontal(a: Double, b: Double, c: Double, d: Double, e: Double) {
    val h = 0 - (b / (2 * a))
    val k = 0 - (d / (2 * c))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val aa = ((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * c))) / a
    val bb = ((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * c))) / c
    val aNew = sqrt(aa)
    val bNew = sqrt(bb)
    val cNew = sqrt(aa - bb)
    val eNew = c / a
    val d1 = h + (a / e)
    val d2 = h - (a / e)
    val latusRectumLength = (2 * b * b) / a
    val lrXP = h + c
    val lrXN = h - c
    val lrYP = k + (b * b) / a
    val lrYN = k - (b * b) / a

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)

    val h1 : String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1 : String = if (k > 0) {
        " - $kF"
    } else if  (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldResult("That is an ellipse!\n\n")

    appendNormalResult("Standard form:\n")
    appendBigBlueBoldResult("(x$h1)²/(${doubleToFraction(aa)}) + (y$k1)²/(${doubleToFraction(bb)}) = 1\n\n")

    appendNormalResult("Center:\n")
    appendBigBlueBoldResult(" (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Major axis:\n")
    appendBigBlueBoldResult("Horizontal, y = ${doubleToFraction(cleank)}\n\n")

    appendNormalResult("Vertices:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh + aNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - aNew)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Co-vertices:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + bNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - bNew)})\n\n")

    appendNormalResult("Foci:\n")
    appendBigBlueBoldResult("(${doubleToFraction(cleanh + cNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - cNew)}, ${doubleToFraction(cleank)})\n\n")

    appendNormalResult("Directrices:\n")
    appendBigBlueBoldResult("x = ${doubleToFraction(d1)} and x = ${doubleToFraction(d2)}\n\n")

    appendNormalResult("Length of latera recta:\n")
    appendBigBlueBoldResult("${doubleToFraction(latusRectumLength)} units\n\n")

    appendNormalResult("Endpoints of latera recta:\n")
    appendBigBlueBoldResult(
        "(${doubleToFraction(lrXP)}, ${doubleToFraction(lrYP)}), " +
                "(${doubleToFraction(lrXP)}, ${doubleToFraction(lrYN)}), " +
                "(${doubleToFraction(lrXN)}, ${doubleToFraction(lrYP)}), " +
                "(${doubleToFraction(lrXN)}, ${doubleToFraction(lrYN)})\n\n")

    appendNormalResult("Values of a, b, c:\n")
    appendBigBlueBoldResult("a = ${doubleToFraction(aNew)}, b = ${doubleToFraction(bNew)}, c = ${doubleToFraction(cNew)}\n\n")

    appendNormalResult("Values of e and d:\n")
    appendBigBlueBoldResult("e = ${doubleToFraction(eNew)}, d = ${doubleToFraction(d1)}\n\n")

    explainEllipseHorizontal(a,b, c, d, e)
}

fun hyperbola(a: Double, b: Double, c: Double, d: Double, e: Double) {
    if (((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c)))>0)) {
        if (a > 0.0 && c < 0.0) {
            val h = 0 - (b / (2 * a))
            val k = 0 - (d / (2 * c))
            val cleanh = if (h == -0.0) 0.0 else h
            val cleank = if (k == -0.0) 0.0 else k
            val aa = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/a)
            val bb = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/c)
            val aNew = sqrt(aa)
            val bNew = sqrt(bb)
            val cNew = sqrt(aa + bb)
            val slope = bNew / aNew

            val kF = doubleToFraction(k)
            val hF = doubleToFraction(h)

            val h1 : String = if (h > 0) {
                " - $hF"
            } else if (h < 0) {
                " + ${doubleToPositiveFraction(h)}"
            } else {
                ""
            }

            val k1 : String = if (k > 0) {
                " - $kF"
            } else if  (k < 0) {
                " + ${doubleToPositiveFraction(k)}"
            } else {
                ""
            }

            appendBigBoldResult("That is a hyperbola!\n\n")

            appendNormalResult("Standard form:\n")
            appendBigBlueBoldResult("(x$h1)²/(${doubleToFraction(aa)}) - (y$k1)²/(${doubleToFraction(bb)}) = 1\n\n")

            appendNormalResult("Transverse axis:\n")
            appendBigBlueBoldResult("Horizontal, y = ${doubleToFraction(cleank)}\n\n")

            appendNormalResult("Center:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Vertices:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh + aNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - aNew)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Foci:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh + cNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - cNew)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Asymptotes:\n")
            appendBigBlueBoldResult("y$k1 = ±${doubleToFraction(slope)}(x$h1)\n\n")

            explainHyperbolaHorizontal(a, b, c, d, e)

        } else {
            val h = 0 - (b / (2 * a))
            val k = 0 - (d / (2 * c))
            val cleanh = if (h == -0.0) 0.0 else h
            val cleank = if (k == -0.0) 0.0 else k
            val aa = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/c)
            val bb = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/a)
            val aNew = sqrt(aa)
            val bNew = sqrt(bb)
            val cNew = sqrt(aa + bb)
            val slope = aNew / bNew

            val kF = doubleToFraction(k)
            val hF = doubleToFraction(h)

            val h1 : String = if (h > 0) {
                " - $hF"
            } else if (h < 0) {
                " + ${doubleToPositiveFraction(h)}"
            } else {
                ""
            }

            val k1 : String = if (k > 0) {
                " - $kF"
            } else if  (k < 0) {
                " + ${doubleToPositiveFraction(k)}"
            } else {
                ""
            }

            appendBigBoldResult("That is a hyperbola!\n\n")

            appendNormalResult("Standard form:\n")
            appendBigBlueBoldResult("(y$k1)²/(${doubleToFraction(aa)}) - (x$h1)²/(${doubleToFraction(bb)}) = 1\n\n")

            appendNormalResult("Transverse axis:\n")
            appendBigBlueBoldResult("Vertical, x = ${doubleToFraction(cleanh)}\n\n")

            appendNormalResult("Center:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Vertices:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + aNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - aNew)})\n\n")

            appendNormalResult("Foci:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + cNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - cNew)})\n\n")

            appendNormalResult("Asymptotes:\n")
            appendBigBlueBoldResult("y$k1 = ±${doubleToFraction(slope)}(x$h1)")

            explainHyperbolaVertical(a, b, c, d, e)
        }
    } else {
        if (a < 0.0 && c > 0.0) {
            val h = 0 - (b / (2 * a))
            val k = 0 - (d / (2 * c))
            val cleanh = if (h == -0.0) 0.0 else h
            val cleank = if (k == -0.0) 0.0 else k
            val aa = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/a)
            val bb = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/c)
            val aNew = sqrt(aa)
            val bNew = sqrt(bb)
            val cNew = sqrt(aa + bb)
            val slope = bNew / aNew

            val kF = doubleToFraction(k)
            val hF = doubleToFraction(h)

            val h1 : String = if (h > 0) {
                " - $hF"
            } else if (h < 0) {
                " + ${doubleToPositiveFraction(h)}"
            } else {
                ""
            }

            val k1 : String = if (k > 0) {
                " - $kF"
            } else if  (k < 0) {
                " + ${doubleToPositiveFraction(k)}"
            } else {
                ""
            }

            appendBigBoldResult("That is a hyperbola!\n\n")

            appendNormalResult("Standard form:\nn")
            appendBigBlueBoldResult("(x$h1)²/(${doubleToFraction(aa)}) - (y$k1)²/(${doubleToFraction(bb)}) = 1\n\n")

            appendNormalResult("Transverse axis:\n")
            appendBigBlueBoldResult("Horizontal, y = ${doubleToFraction(cleank)}\n\n")

            appendNormalResult("Center:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Vertices:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh + aNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - aNew)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Foci:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh + cNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - cNew)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Asymptotes:\n")
            appendBigBlueBoldResult("y$k1 = ±${doubleToFraction(slope)}(x$h1)\n\n")

            explainHyperbolaHorizontal(a, b, c, d, e)
        } else {
            val h = 0 - (b / (2 * a))
            val k = 0 - (d / (2 * c))
            val cleanh = if (h == -0.0) 0.0 else h
            val cleank = if (k == -0.0) 0.0 else k
            val aa = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/c)
            val bb = abs(((0-e)+((b*b)/(4*a))-((d*d)/(4*(0-c))))/a)
            val aNew = sqrt(aa)
            val bNew = sqrt(bb)
            val cNew = sqrt(aa + bb)
            val slope = aNew / bNew

            val kF = doubleToFraction(k)
            val hF = doubleToFraction(h)

            val h1 : String = if (h > 0) {
                " - $hF"
            } else if (h < 0) {
                " + ${doubleToPositiveFraction(h)}"
            } else {
                ""
            }

            val k1 : String = if (k > 0) {
                " - $kF"
            } else if  (k < 0) {
                " + ${doubleToPositiveFraction(k)}"
            } else {
                ""
            }

            appendBigBoldResult("That is a hyperbola!\n\n")

            appendNormalResult("Standard form:\n")
            appendBigBlueBoldResult("(y$k1)²/(${doubleToFraction(aa)}) - (x$h1)²/(${doubleToFraction(bb)}) = 1\n\n")

            appendNormalResult("Transverse axis:\n")
            appendBigBlueBoldResult("Vertical, x = ${doubleToFraction(cleanh)}\n\n")

            appendNormalResult("Center:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank)})\n\n")

            appendNormalResult("Vertices:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + aNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - aNew)})\n\n")

            appendNormalResult("Foci:\n")
            appendBigBlueBoldResult("(${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + cNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - cNew)})\n\n")

            appendNormalResult("Asymptotes:\n")
            appendBigBlueBoldResult("y$k1 = ±${doubleToFraction(slope)}(x$h1)\n\n")

            explainHyperbolaVertical(a, b, c, d, e)
        }
    }
}