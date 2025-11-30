package com.example.mlmtest1_721.ui.conicsections

import kotlin.math.abs
import kotlin.math.pow
import kotlin.math.sqrt

fun explainCircle(a: Double, b: Double, c: Double, d: Double, e: Double) {
    val h = 0-(b / (2 * a))
    val k = 0-(d / (2 * c))
    val rr = (((0 - e) + ((b * b) / (4 * a)) + ((d * d) / (4 * a))) / a)

    val bNew = doubleToFraction(b / a)
    val dNew = doubleToFraction(d / a)
    val eNew = doubleToFraction(e / a)

    val hF = doubleToFraction(h)
    val kF = doubleToFraction(k)
    val completingX = doubleToFraction((b/(2*a)).pow(2))
    val completingY = doubleToFraction((d/(2*a)).pow(2))
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

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is a Circle!\n")
    appendNormalExplanation("Since A is equal to C\n")
    appendNormalExplanation("Note: Standard form of a circle is (x - h)² + (y - k)² = r²\n")
    appendNormalExplanation("Where: Center of the circle is (h, k) and r is the radius\n\n")

    appendBigBoldExplanation("We start with the general equation:\n")
    appendBigBlueBoldExplanation("(${a})x² + (${b})x + (${c})y² + (${d})y + ($e) = 0\n\n")

    if (a != 1.0 && c != 1.0) {
        appendNormalExplanation("Since A and C is not equal to 1, we should divide the whole equation by A or C before proceeding\n")
        appendNormalExplanation("The new equation now will then be:\n")
        appendBigBlueBoldExplanation("x² + (${bNew})x + y² + (${dNew})y + ($eNew) = 0\n\n")
    }

    appendBigBoldExplanation("Step 1: We will find the center of the circle\n")
    appendNormalExplanation("Combine like terms and transpose the constant, E, to the right side\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x) + (y² + (${dNew})y) = 0 - ($eNew)\n\n")

    appendBigBoldExplanation("Step 2: Complete the square of the x and y variables\n")
    appendNormalExplanation("Note: to complete the square of Ax² + Bx, we will add (B/2A)²\n")
    appendBigBlueBoldExplanation("((x² + (${bNew})x + ($completingX)) + (y² + (${dNew})y + ($completingY)) = 0 - ($eNew)\n\n")

    appendNormalExplanation("Since we added new terms to the left side of the equation, we should add them also to the right side to make the equation true\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x + ($completingX)) + (y² + (${dNew})y + ($completingY)) = 0 - ($eNew) + ($completingX) + ($completingY)\n\n")

    appendBigBoldExplanation("Step 3: Rewrite the expressions as perfect squares and simplify to get the standard form of the circle\n")
    appendBigBlueBoldExplanation("(x$h1)² + (y$k1)² = $rrF\n\n")

    appendBigBlueBoldExplanation("Thus, center is ($h, $k) and radius is $rF\n")
}

fun explainParabolaDown(a: Double, b: Double, d: Double, e: Double) { // WORKING FINALLY!!!
    val h = 0 - (b / (2 * a))
    val k = ((0 - e) / d) + ((b * b) / (4 * a * d))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = d / a
    val p = a4 / 4

    val bNew = b / a
    val dNew = d / a
    val eNew = e / a
    val completingX = (bNew/2).pow(2)

    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

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

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is a Parabola!\n")
    appendNormalExplanation("Since either A or C is missing but not both\n\n")

    if (a != 1.0) {
        appendNormalExplanation("Since A is not equal to 1, we should divide the whole equation by A before proceeding\n")
        appendNormalExplanation("The new equation now will then be:\n")
        appendNormalExplanation("x² + (${bNew})x + (${dNew})y + ($eNew) = 0\n\n")
    }

    appendBigBoldExplanation("Step 1: We will get the standard formula of the parabola\n")
    appendNormalExplanation("Place x² and Bx on the left side while transpose the constant, E, and Dy to the right side\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x) = 0 - ($eNew) - (${dNew}y)\n\n")

    appendBigBoldExplanation("Step 2: Complete the square of the left side\n")
    appendNormalExplanation("Note: To complete the square of Ax² + Bx, we will add (B/2A)²\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x) + (${completingX}) = 0 - ($eNew) - (${dNew})y\n\n")

    appendNormalExplanation("Since we added new terms to the left side of the equation, we should add them also to the right side to make the equation true\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x) + (${completingX}) = 0 - ($eNew) - (${dNew})y + (${completingX})\n\n")

    appendBigBoldExplanation("Step 3: Rewrite the left side of the equation as a perfect square and factor out D on the right side to get the standard formula of the parabola\n")
    appendBigBlueBoldExplanation("(x$h1)² = -${doubleToFraction(a4)}(y$k1)\n\n")

    appendBigBoldExplanation("Step 4: Now that we have the standard formula of the parabola, we can get its properties\n")
    appendNormalExplanation("It's now in the form of (x - h)² = -4a(y - k)\n")
    appendNormalExplanation("Where: Vertex of the parabola is (h, k) and 4a is the length of the latus rectum\n\n")

    appendBigBoldExplanation("Step 5: Now that we have the standard form of the parabola, we can get the other properties of the parabola\n\n")

    appendNormalExplanation("Since the right side of the equation is negative and x has an exponent of 2,\n")
    appendBigBoldExplanation("the parabola opens downwards\n\n")

    appendBigBoldExplanation("From the standard formula, we can get the vertex of the parabola\n")
    appendNormalExplanation("The x-coordinate is beside x and y-coordinate is beside y; thus\n")
    appendBigBlueBoldExplanation("Vertex: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Next, we get the focus\n")
    appendNormalExplanation("Note: The focus is 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is $a4, the distance of focus from the vertex is $p\n")
    appendNormalExplanation("We need to consider the direction the parabola\n")
    appendNormalExplanation("Because the parabola opens downwards, the focus is below the center; and thus\n")
    appendBigBlueBoldExplanation("Focus: (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - p)})\n\n")

    appendBigBoldExplanation("Next, we get the axis of symmetry\n")
    appendNormalExplanation("The axis of symmetry is the line that bisects the parabola\n")
    appendNormalExplanation("Since the parabola opens downwards, it will have a left-right symmetry\n")
    appendNormalExplanation("The axis of symmetry is vertical and passes through the vertex and focus; thus\n")
    appendBigBlueBoldExplanation("x = ${doubleToFraction(cleanh)}\n\n")

    appendBigBoldExplanation("Next, we get the equation of directrix\n")
    appendNormalExplanation("The equation of directrix a line located at the opposite direction where the parabola opens\n")
    appendNormalExplanation("It is also 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is $a4, the distance of directrix from the vertex is $p\n")
    appendNormalExplanation("Because the parabola opens downwards, the directrix will be $p units above the vertex; thus\n")
    appendBigBlueBoldExplanation("y = ${doubleToFraction(cleank + p)}\n\n")

    appendBigBoldExplanation("Next, we get the ends of the latus rectum\n")
    appendNormalExplanation("The latus rectum is a line that is perpendicular to the axis of symmetry and passes through the focus\n")
    appendNormalExplanation("Its length is 4a which can be found in the standard form of the parabola\n")
    appendNormalExplanation("Because the parabola opens downwards, one end of the latus rectum will be 2a units to the left of the focus while the other is 2a units to the right; thus\n")
    appendNormalExplanation("The ends of the latus rectum are:\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(cleanh - (2 * p))}, ${doubleToFraction(cleank - p)}) and (${doubleToFraction(cleanh + (2 * p))}, ${doubleToFraction(cleank - p)})\n\n")
}

fun explainParabolaUp(a: Double, b: Double, d: Double, e: Double) { // WORKING FINALLY!!!
    val h = 0 - (b / (2 * a))
    val k = ((0 - e) / d) + ((b * b) / (4 * a * d))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = (0 - d) / a
    val p = a4 / 4

    val bNew = b / a
    val dNew = d / a
    val eNew = e / a
    val completingX = (bNew/2).pow(2)

    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

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

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is a Parabola!\n")
    appendNormalExplanation("Since either A or C is missing but not both\n\n")

    if (a != 1.0) {
        appendNormalExplanation("Since A is not equal to 1, we should divide the whole equation by A before proceeding\n")
        appendNormalExplanation("The new equation now will then be:\n")
        appendNormalExplanation("x² + (${bNew})x + (${dNew})y + ($eNew) = 0\n\n")
    }

    appendBigBoldExplanation("Step 1: We will get the standard formula of the parabola\n")
    appendNormalExplanation("Place x² and Bx on the left side while transpose the constant, E, and Dy to the right side\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x) = 0 - ($eNew) - (${dNew}y)\n\n")

    appendBigBoldExplanation("Step 2: Complete the square of the left side\n")
    appendNormalExplanation("Note: To complete the square of Ax² + Bx, we will add (B/2A)²\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x) + (${completingX}) = 0 - ($eNew) - (${dNew}y)\n\n")

    appendNormalExplanation("Since we added new terms to the left side of the equation, we should add them also to the right side to make the equation true\n")
    appendBigBlueBoldExplanation("(x² + (${bNew})x) + (${completingX}) = 0 - ($eNew) - (${dNew}y) + (${completingX})\n\n")

    appendBigBoldExplanation("Step 3: Rewrite the left side of the equation as a perfect square and factor out D on the right side to get the standard formula of the parabola\n")
    appendBigBlueBoldExplanation("(x$h1)² = ${doubleToFraction(a4)}(y$k1)\n\n")

    appendBigBoldExplanation("Step 4: Now that we have the standard formula of the parabola, we can get its properties\n")
    appendNormalExplanation("It's now in the form of (x - h)² = 4a(y - k)\n")
    appendNormalExplanation("Where: Vertex of the parabola is (h, k) and 4a is the length of the latus rectum\n\n")

    appendBigBoldExplanation("Step 5: Now that we have the standard form of the parabola, we can get the other properties of the parabola\n\n")

    appendNormalExplanation("Since the right side of the equation is positive and x has an exponent of 2,\n")
    appendBigBoldExplanation("the parabola opens upwards\n\n")

    appendBigBoldExplanation("From the standard formula, we can get the vertex of the parabola\n")
    appendNormalExplanation("The x-coordinate is beside x and y-coordinate is beside y; thus\n")
    appendBigBlueBoldExplanation("Vertex: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Next, we get the focus\n")
    appendNormalExplanation("Note: The focus is 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is ${doubleToPositiveFraction(a4)}, the distance of focus from the vertex is ${doubleToPositiveFraction(p)}\n")
    appendNormalExplanation("We need to consider the direction the parabola\n")
    appendNormalExplanation("Because the parabola opens upwards, the focus is above the center; and thus\n")
    appendBigBlueBoldExplanation("Focus: (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + p)})\n\n")

    appendBigBoldExplanation("Next, we get the axis of symmetry\n")
    appendNormalExplanation("The axis of symmetry is the line that bisects the parabola\n")
    appendNormalExplanation("Since the parabola opens upwards, it will have a left-right symmetry\n")
    appendNormalExplanation("The axis of symmetry is vertical and passes through the vertex and focus; thus\n")
    appendBigBlueBoldExplanation("x = ${doubleToFraction(cleanh)}\n\n")

    appendBigBoldExplanation("Next, we get the equation of directrix\n")
    appendNormalExplanation("The equation of directrix a line located at the opposite direction where the parabola opens\n")
    appendNormalExplanation("It is also 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is $a4, the distance of directrix from the vertex is $p\n")
    appendNormalExplanation("Because the parabola opens upwards, the directrix will be $p units below the vertex; thus\n")
    appendBigBlueBoldExplanation("y = ${doubleToFraction(cleank - p)}\n\n")

    appendBigBoldExplanation("Next, we get the ends of the latus rectum\n")
    appendNormalExplanation("The latus rectum is a line that is perpendicular to the axis of symmetry and passes through the focus\n")
    appendNormalExplanation("Its length is 4a which can be found in the standard form of the parabola\n")
    appendNormalExplanation("Because the parabola opens upwards, one end of the latus rectum will be 2a units to the left of the focus while the other is 2a units to the right; thus\n")
    appendNormalExplanation("The ends of the latus rectum are:\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(cleanh - (2 * p))}, ${doubleToFraction(cleank + p)}) and (${doubleToFraction(cleanh + (2 * p))}, ${doubleToFraction(cleank + p)})\n\n")
}

fun explainParabolaLeft(b: Double, c: Double, d: Double, e: Double) { // WORKING FINALLY!!!
    val k = 0 - (d / (2 * c))
    val h = ((0 - e) / b) + ((d * d) / (4 * c * b))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = b / c
    val p = a4 / 4

    val bNew = b / c
    val dNew = d / c
    val eNew = e / c
    val completingY = (dNew/2).pow(2)
    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

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

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is a Parabola!\n")
    appendNormalExplanation("Since either A or C is missing but not both\n\n")

    if (c != 1.0) {
        appendNormalExplanation("Since C is not equal to 1, we should divide the whole equation by A before proceeding\n")
        appendNormalExplanation("The new equation now will then be:\n")
        appendNormalExplanation("y² + (${dNew})y + (${bNew})x + ($eNew) = 0\n\n")
    }

    appendBigBoldExplanation("Step 1: We will get the standard formula of the parabola\n")
    appendNormalExplanation("Place y² and Dy on the left side while transpose the constant, E, and Bx to the right side\n")
    appendBigBlueBoldExplanation("(y² + (${bNew})y) = 0 - ($eNew) - (${bNew}x)\n\n")

    appendBigBoldExplanation("Step 2: Complete the square of the left side\n")
    appendNormalExplanation("Note: To complete the square of Ax² + Bx, we will add (B/2A)²\n")
    appendBigBlueBoldExplanation("(y² + (${bNew})y) + (${completingY}) = 0 - ($eNew) - (${dNew}x)\n\n")

    appendNormalExplanation("Since we added new terms to the left side of the equation, we should add them also to the right side to make the equation true\n")
    appendBigBlueBoldExplanation("(y² + (${bNew})y) + (${completingY}) = 0 - ($eNew) - (${dNew}x) + (${completingY})\n\n")

    appendBigBoldExplanation("Step 3: Rewrite the left side of the equation as a perfect square and factor out D on the right side to get the standard formula of the parabola\n")
    appendBigBlueBoldExplanation("(y$k1)² = -${doubleToFraction(a4)}(x$h1)\n\n")

    appendBigBoldExplanation("Step 4: Now that we have the standard formula of the parabola, we can get its properties\n")
    appendNormalExplanation("It's now in the form of (y - k)² = -4a(x - h)\n")
    appendNormalExplanation("Where: Vertex of the parabola is (h, k) and 4a is the length of the latus rectum\n\n")

    appendBigBoldExplanation("Step 5: Now that we have the standard form of the parabola, we can get the other properties of the parabola\n\n")

    appendNormalExplanation("Since the right side of the equation is negative and y has an exponent of 2,\n")
    appendBigBoldExplanation("the parabola opens to the left\n\n")

    appendBigBoldExplanation("From the standard formula, we can get the vertex of the parabola\n")
    appendNormalExplanation("The x-coordinate is beside x and y-coordinate is beside y; thus\n")
    appendBigBlueBoldExplanation("Vertex: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Next, we get the focus\n")
    appendNormalExplanation("Note: The focus is 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is $a4, the distance of focus from the vertex is $p\n")
    appendNormalExplanation("We need to consider the direction the parabola\n")
    appendNormalExplanation("Because the parabola opens to the left, the focus is to the left of the center; and thus\n")
    appendBigBlueBoldExplanation("Focus: (${doubleToFraction(cleanh - p)}, ${doubleToFraction(cleank)})\n\n")

    appendBigBoldExplanation("Next, we get the axis of symmetry\n")
    appendNormalExplanation("The axis of symmetry is the line that bisects the parabola\n")
    appendNormalExplanation("Since the parabola opens to the left, it will have a up-down symmetry\n")
    appendNormalExplanation("The axis of symmetry is horizontal and passes through the vertex and focus; thus\n")
    appendBigBlueBoldExplanation("y = ${doubleToFraction(cleank)}\n\n")

    appendBigBoldExplanation("Next, we get the equation of directrix\n")
    appendNormalExplanation("The equation of directrix a line located at the opposite direction where the parabola opens\n")
    appendNormalExplanation("It is also 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is $a4, the distance of directrix from the vertex is $p\n")
    appendNormalExplanation("Because the parabola opens to the left, the directrix will be $p units to the right of the vertex; thus\n")
    appendBigBlueBoldExplanation("x = ${doubleToFraction(cleanh + p)}\n\n")

    appendBigBoldExplanation("Next, we get the ends of the latus rectum\n")
    appendNormalExplanation("The latus rectum is a line that is perpendicular to the axis of symmetry and passes through the focus\n")
    appendNormalExplanation("Its length is 4a which can be found in the standard form of the parabola\n")
    appendNormalExplanation("Because the parabola opens to the left, one end of the latus rectum will be 2a units above the focus while the other is 2a units down; thus\n")
    appendNormalExplanation("The ends of the latus rectum are:\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(cleanh - p)}, ${doubleToFraction(cleank - (2 * p))}) and (${doubleToFraction(cleanh - p)}, ${doubleToFraction(cleank + (2 * p))})\n\n")
}

fun explainParabolaRight(b: Double, c: Double, d: Double, e: Double) { // WORKING FINALLY!!!
    val k = 0 - (d / (2 * c))
    val h = ((0 - e) / b) + ((d * d) / (4 * c * b))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val a4 = (0 - b) / c
    val p = a4 / 4

    val bNew = b / c
    val dNew = d / c
    val eNew = e / c
    val completingY = (dNew/2).pow(2)
    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

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

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is a Parabola!\n")
    appendNormalExplanation("Since either A or C is missing but not both\n\n")

    if (c != 1.0) {
        appendNormalExplanation("Since C is not equal to 1, we should divide the whole equation by A before proceeding\n")
        appendNormalExplanation("The new equation now will then be:\n")
        appendNormalExplanation("y² + (${dNew})y + (${bNew})x + ($eNew) = 0\n\n")
    }

    appendBigBoldExplanation("Step 1: We will get the standard formula of the parabola\n")
    appendNormalExplanation("Place y² and Dy on the left side while transpose the constant, E, and Bx to the right side\n")
    appendBigBlueBoldExplanation("(y² + (${bNew})y) = 0 - ($eNew) - (${bNew}x)\n\n")

    appendBigBoldExplanation("Step 2: Complete the square of the left side\n")
    appendNormalExplanation("Note: To complete the square of Ax² + Bx, we will add (B/2A)²\n")
    appendBigBlueBoldExplanation("(y² + (${bNew})y) + (${completingY}) = 0 - ($eNew) - (${dNew}x)\n\n")

    appendNormalExplanation("Since we added new terms to the left side of the equation, we should add them also to the right side to make the equation true\n")
    appendBigBlueBoldExplanation("(y² + (${bNew})y) + (${completingY}) = 0 - ($eNew) - (${dNew}x) + (${completingY})\n\n")

    appendBigBoldExplanation("Step 3: Rewrite the left side of the equation as a perfect square and factor out D on the right side to get the standard formula of the parabola\n")
    appendBigBlueBoldExplanation("(y$k1)² = ${doubleToFraction(a4)}(x$h1)\n\n")

    appendBigBoldExplanation("Step 4: Now that we have the standard formula of the parabola, we can get its properties\n")
    appendNormalExplanation("It's now in the form of (y - k)² = 4a(x - h)\n")
    appendNormalExplanation("Where: Vertex of the parabola is (h, k) and 4a is the length of the latus rectum\n\n")

    appendBigBoldExplanation("Step 5: Now that we have the standard form of the parabola, we can get the other properties of the parabola\n\n")

    appendNormalExplanation("Since the right side of the equation is positive and y has an exponent of 2,\n")
    appendBigBoldExplanation("the parabola opens to the right\n\n")

    appendBigBoldExplanation("From the standard formula, we can get the vertex of the parabola\n")
    appendNormalExplanation("The x-coordinate is beside x and y-coordinate is beside y; thus\n")
    appendBigBlueBoldExplanation("Vertex: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Next, we get the focus\n")
    appendNormalExplanation("Note: The focus is 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is $a4, the distance of focus from the vertex is $p\n")
    appendNormalExplanation("We need to consider the direction the parabola\n")
    appendNormalExplanation("Because the parabola opens to the right, the focus is to the right of the center; and thus\n")
    appendBigBlueBoldExplanation("Focus: (${doubleToFraction(cleanh + p)}, ${doubleToFraction(cleank)})\n\n")

    appendBigBoldExplanation("Next, we get the axis of symmetry\n")
    appendNormalExplanation("The axis of symmetry is the line that bisects the parabola\n")
    appendNormalExplanation("Since the parabola opens to the right, it will have a up-down symmetry\n")
    appendNormalExplanation("The axis of symmetry is horizontal and passes through the vertex and focus; thus\n")
    appendBigBlueBoldExplanation("y = ${doubleToFraction(cleank)}\n\n")

    appendBigBoldExplanation("Next, we get the equation of directrix\n")
    appendNormalExplanation("The equation of directrix a line located at the opposite direction where the parabola opens\n")
    appendNormalExplanation("It is also 1/4 of the distance of the latus rectum away from the vertex\n")
    appendNormalExplanation("Since length of latus rectum is $a4, the distance of directrix from the vertex is $p\n")
    appendNormalExplanation("Because the parabola opens to the right, the directrix will be $p units to the left of the vertex; thus\n")
    appendBigBlueBoldExplanation("x = ${doubleToFraction(cleanh - p)}\n\n")

    appendBigBoldExplanation("Next, we get the ends of the latus rectum\n")
    appendNormalExplanation("The latus rectum is a line that is perpendicular to the axis of symmetry and passes through the focus\n")
    appendNormalExplanation("Its length is 4a which can be found in the standard form of the parabola\n")
    appendNormalExplanation("Because the parabola opens to the right, one end of the latus rectum will be 2a units above the focus while the other is 2a units down; thus\n")
    appendNormalExplanation("The ends of the latus rectum are:\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(cleanh + p)}, ${doubleToFraction(cleank - (2 * p))}) and (${doubleToFraction(cleanh + p)}, ${doubleToFraction(cleank + (2 * p))})\n\n")
}

fun explainEllipseVertical(a: Double, b: Double, c: Double, d: Double, e: Double) {
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

    val bNewCoeff = b / a
    val dNewCoeff = d / c
    val eNewCoeff = e / a  // Assuming we normalize by a for x terms, but adjust as needed
    val completingX = (bNewCoeff / 2).pow(2)
    val completingY = (dNewCoeff / 2).pow(2)

    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

    val h1: String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1: String = if (k > 0) {
        " - $kF"
    } else if (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is an Ellipse!\n")
    appendNormalExplanation("Since both A and C are present and positive, and the discriminant conditions are met\n\n")

    appendBigBoldExplanation("Step 1: We will get the standard formula of the ellipse\n")
    appendNormalExplanation("Group the x² and x terms together, and y² and y terms together, while moving the constant to the right side\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)})\n\n")

    appendBigBoldExplanation("Step 2: Complete the square for x terms\n")
    appendNormalExplanation("To complete the square for Ax² + Bx, add (B/2A)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)}) + (${doubleToFraction(completingX)})\n\n")

    appendBigBoldExplanation("Step 3: Complete the square for y terms\n")
    appendNormalExplanation("To complete the square for Cy² + Dy, add (D/2C)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y + (${doubleToFraction(completingY)}) = 0 - (${doubleToFraction(e)}) + (${doubleToFraction(completingX)}) + (${doubleToFraction(completingY)})\n\n")

    appendBigBoldExplanation("Step 4: Rewrite as perfect squares and factor\n")
    appendNormalExplanation("Factor the x and y terms into perfect squares\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})(x + (${doubleToFraction(b/(2*a))}))² + (${doubleToFraction(c)})(y + (${doubleToFraction(d/(2*c))}))² = ${doubleToFraction((0 - e) + completingX + completingY)}\n\n")

    appendBigBoldExplanation("Step 5: Divide both sides by the constant to get the standard form\n")
    appendNormalExplanation("Divide the entire equation by the right-hand side constant to make it equal to 1\n")
    appendBigBlueBoldExplanation("(x$h1)²/(${doubleToFraction(bb)}) + (y$k1)²/(${doubleToFraction(aa)}) = 1\n\n")

    appendBigBoldExplanation("Step 6: Now that we have the standard form, we can get the properties of the ellipse\n")
    appendNormalExplanation("Since the denominator under y² is larger, the major axis is vertical\n\n")

    appendBigBoldExplanation("Center of the ellipse\n")
    appendNormalExplanation("The center is the point (h, k) from the standard form\n")
    appendBigBlueBoldExplanation("Center: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Major axis\n")
    appendNormalExplanation("The major axis is the longer axis, which is vertical since a > b\n")
    appendBigBlueBoldExplanation("Major axis: Vertical, x = $hF\n\n")

    appendBigBoldExplanation("Vertices\n")
    appendNormalExplanation("Vertices are the endpoints of the major axis\n")
    appendBigBlueBoldExplanation("Vertices: (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + aNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - aNew)})\n\n")

    appendBigBoldExplanation("Co-vertices\n")
    appendNormalExplanation("Co-vertices are the endpoints of the minor axis\n")
    appendBigBlueBoldExplanation("Co-vertices: (${doubleToFraction(cleanh + bNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - bNew)}, ${doubleToFraction(cleank)})\n\n")

    appendBigBoldExplanation("Foci\n")
    appendNormalExplanation("Foci are located along the major axis, at a distance c from the center\n")
    appendBigBlueBoldExplanation("Foci: (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + cNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - cNew)})\n\n")

    appendBigBoldExplanation("Directrices\n")
    appendNormalExplanation("Directrices are lines perpendicular to the major axis at distance a/e from the center\n")
    appendBigBlueBoldExplanation("Directrices: y = ${doubleToFraction(d1)} and y = ${doubleToFraction(d2)}\n\n")

    appendBigBoldExplanation("Length of latus rectum\n")
    appendNormalExplanation("The latus rectum length is 2b²/a\n")
    appendBigBlueBoldExplanation("Length: ${doubleToFraction(latusRectumLength)} units\n\n")

    appendBigBoldExplanation("Endpoints of latus rectum\n")
    appendNormalExplanation("These are points on the ellipse along lines parallel to the minor axis through the foci\n")
    appendBigBlueBoldExplanation("Endpoints: (${doubleToFraction(lrXP)}, ${doubleToFraction(lrYP)}), (${doubleToFraction(lrXP)}, ${doubleToFraction(lrYN)}), (${doubleToFraction(lrXN)}, ${doubleToFraction(lrYP)}), (${doubleToFraction(lrXN)}, ${doubleToFraction(lrYN)})\n\n")

    appendBigBoldExplanation("Values of a, b, c\n")
    appendNormalExplanation("a is the semi-major axis, b semi-minor, c the focal distance\n")
    appendBigBlueBoldExplanation("a = ${doubleToFraction(aNew)}, b = ${doubleToFraction(bNew)}, c = ${doubleToFraction(cNew)}\n\n")

    appendBigBoldExplanation("Eccentricity and directrix distance\n")
    appendNormalExplanation("Eccentricity e = c/a, and d is the distance to directrix\n")
    appendBigBlueBoldExplanation("e = ${doubleToFraction(eNew)}, d = ${doubleToFraction(d1)}\n\n")
}

fun explainEllipseHorizontal(a: Double, b: Double, c: Double, d: Double, e: Double) {
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

    val bNewCoeff = b / a
    val dNewCoeff = d / c
    val eNewCoeff = e / a
    val completingX = (bNewCoeff / 2).pow(2)
    val completingY = (dNewCoeff / 2).pow(2)

    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

    val h1: String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1: String = if (k > 0) {
        " - $kF"
    } else if (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is an Ellipse!\n")
    appendNormalExplanation("Since both A and C are present and positive, and the discriminant conditions are met\n\n")

    appendBigBoldExplanation("Step 1: We will get the standard formula of the ellipse\n")
    appendNormalExplanation("Group the x² and x terms together, and y² and y terms together, while moving the constant to the right side\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)})\n\n")

    appendBigBoldExplanation("Step 2: Complete the square for x terms\n")
    appendNormalExplanation("To complete the square for Ax² + Bx, add (B/2A)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)}) + (${doubleToFraction(completingX)})\n\n")

    appendBigBoldExplanation("Step 3: Complete the square for y terms\n")
    appendNormalExplanation("To complete the square for Cy² + Dy, add (D/2C)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y + (${doubleToFraction(completingY)}) = 0 - (${doubleToFraction(e)}) + (${doubleToFraction(completingX)}) + (${doubleToFraction(completingY)})\n\n")

    appendBigBoldExplanation("Step 4: Rewrite as perfect squares and factor\n")
    appendNormalExplanation("Factor the x and y terms into perfect squares\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})(x + (${doubleToFraction(b/(2*a))}))² + (${doubleToFraction(c)})(y + (${doubleToFraction(d/(2*c))}))² = ${doubleToFraction((0 - e) + completingX + completingY)}\n\n")

    appendBigBoldExplanation("Step 5: Divide both sides by the constant to get the standard form\n")
    appendNormalExplanation("Divide the entire equation by the right-hand side constant to make it equal to 1\n")
    appendBigBlueBoldExplanation("(x$h1)²/(${doubleToFraction(aa)}) + (y$k1)²/(${doubleToFraction(bb)}) = 1\n\n")

    appendBigBoldExplanation("Step 6: Now that we have the standard form, we can get the properties of the ellipse\n")
    appendNormalExplanation("Since the denominator under x² is larger, the major axis is horizontal\n\n")

    appendBigBoldExplanation("Center of the ellipse\n")
    appendNormalExplanation("The center is the point (h, k) from the standard form\n")
    appendBigBlueBoldExplanation("Center: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Major axis\n")
    appendNormalExplanation("The major axis is the longer axis, which is horizontal since a > b\n")
    appendBigBlueBoldExplanation("Major axis: Horizontal, y = $kF\n\n")

    appendBigBoldExplanation("Vertices\n")
    appendNormalExplanation("Vertices are the endpoints of the major axis\n")
    appendBigBlueBoldExplanation("Vertices: (${doubleToFraction(cleanh + aNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - aNew)}, ${doubleToFraction(cleank)})\n\n")

    appendBigBoldExplanation("Co-vertices\n")
    appendNormalExplanation("Co-vertices are the endpoints of the minor axis\n")
    appendBigBlueBoldExplanation("Co-vertices: (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + bNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - bNew)})\n\n")

    appendBigBoldExplanation("Foci\n")
    appendNormalExplanation("Foci are located along the major axis, at a distance c from the center\n")
    appendBigBlueBoldExplanation("Foci: (${doubleToFraction(cleanh + cNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - cNew)}, ${doubleToFraction(cleank)})\n\n")

    appendBigBoldExplanation("Directrices\n")
    appendNormalExplanation("Directrices are lines perpendicular to the major axis at distance a/e from the center\n")
    appendBigBlueBoldExplanation("Directrices: x = ${doubleToFraction(d1)} and x = ${doubleToFraction(d2)}\n\n")

    appendBigBoldExplanation("Length of latus rectum\n")
    appendNormalExplanation("The latus rectum length is 2b²/a\n")
    appendBigBlueBoldExplanation("Length: ${doubleToFraction(latusRectumLength)} units\n\n")

    appendBigBoldExplanation("Endpoints of latus rectum\n")
    appendNormalExplanation("These are points on the ellipse along lines parallel to the minor axis through the foci\n")
    appendBigBlueBoldExplanation("Endpoints: (${doubleToFraction(lrXP)}, ${doubleToFraction(lrYP)}), (${doubleToFraction(lrXP)}, ${doubleToFraction(lrYN)}), (${doubleToFraction(lrXN)}, ${doubleToFraction(lrYP)}), (${doubleToFraction(lrXN)}, ${doubleToFraction(lrYN)})\n\n")

    appendBigBoldExplanation("Values of a, b, c\n")
    appendNormalExplanation("a is the semi-major axis, b semi-minor, c the focal distance\n")
    appendBigBlueBoldExplanation("a = ${doubleToFraction(aNew)}, b = ${doubleToFraction(bNew)}, c = ${doubleToFraction(cNew)}\n\n")

    appendBigBoldExplanation("Eccentricity and directrix distance\n")
    appendNormalExplanation("Eccentricity e = c/a, and d is the distance to directrix\n")
    appendBigBlueBoldExplanation("e = ${doubleToFraction(eNew)}, d = ${doubleToFraction(d1)}\n\n")
}

fun explainHyperbolaHorizontal(a: Double, b: Double, c: Double, d: Double, e: Double) {
    val h = 0 - (b / (2 * a))
    val k = 0 - (d / (2 * c))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val aa = abs(((0 - e) + ((b * b) / (4 * a)) - ((d * d) / (4 * (0 - c)))) / a)
    val bb = abs(((0 - e) + ((b * b) / (4 * a)) - ((d * d) / (4 * (0 - c)))) / c)
    val aNew = sqrt(aa)
    val bNew = sqrt(bb)
    val cNew = sqrt(aa + bb)
    val slope = bNew / aNew

    val bNewCoeff = b / a
    val dNewCoeff = d / c
    val eNewCoeff = e / a
    val completingX = (bNewCoeff / 2).pow(2)
    val completingY = (dNewCoeff / 2).pow(2)

    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

    val h1: String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1: String = if (k > 0) {
        " - $kF"
    } else if (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is a Hyperbola!\n")
    appendNormalExplanation("Since A and C have opposite signs, and the discriminant condition is met\n\n")

    appendBigBoldExplanation("Step 1: We will get the standard formula of the hyperbola\n")
    appendNormalExplanation("Group the x² and x terms together, and y² and y terms together, while moving the constant to the right side\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)})\n\n")

    appendBigBoldExplanation("Step 2: Complete the square for x terms\n")
    appendNormalExplanation("To complete the square for Ax² + Bx, add (B/2A)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)}) + (${doubleToFraction(completingX)})\n\n")

    appendBigBoldExplanation("Step 3: Complete the square for y terms\n")
    appendNormalExplanation("To complete the square for Cy² + Dy, add (D/2C)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y + (${doubleToFraction(completingY)}) = 0 - (${doubleToFraction(e)}) + (${doubleToFraction(completingX)}) + (${doubleToFraction(completingY)})\n\n")

    appendBigBoldExplanation("Step 4: Rewrite as perfect squares and factor\n")
    appendNormalExplanation("Factor the x and y terms into perfect squares\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})(x + (${doubleToFraction(b/(2*a))}))² + (${doubleToFraction(c)})(y + (${doubleToFraction(d/(2*c))}))² = ${doubleToFraction((0 - e) + completingX + completingY)}\n\n")

    appendBigBoldExplanation("Step 5: Divide both sides by the constant to get the standard form\n")
    appendNormalExplanation("Divide the entire equation by the right-hand side constant to make it equal to 1\n")
    appendBigBlueBoldExplanation("(x$h1)²/(${doubleToFraction(aa)}) - (y$k1)²/(${doubleToFraction(bb)}) = 1\n\n")

    appendBigBoldExplanation("Step 6: Now that we have the standard form, we can get the properties of the hyperbola\n")
    appendNormalExplanation("Since the x² term is positive and y² is negative, the transverse axis is horizontal\n\n")

    appendBigBoldExplanation("Transverse axis\n")
    appendNormalExplanation("The transverse axis is the line joining the vertices, horizontal in this case\n")
    appendBigBlueBoldExplanation("Transverse axis: Horizontal, y = $kF\n\n")

    appendBigBoldExplanation("Center of the hyperbola\n")
    appendNormalExplanation("The center is the point (h, k) from the standard form\n")
    appendBigBlueBoldExplanation("Center: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Vertices\n")
    appendNormalExplanation("Vertices are the endpoints of the transverse axis\n")
    appendBigBlueBoldExplanation("Vertices: (${doubleToFraction(cleanh + aNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - aNew)}, ${doubleToFraction(cleank)})\n\n")

    appendBigBoldExplanation("Foci\n")
    appendNormalExplanation("Foci are located along the transverse axis, at a distance c from the center\n")
    appendBigBlueBoldExplanation("Foci: (${doubleToFraction(cleanh + cNew)}, ${doubleToFraction(cleank)}) and (${doubleToFraction(cleanh - cNew)}, ${doubleToFraction(cleank)})\n\n")

    appendBigBoldExplanation("Asymptotes\n")
    appendNormalExplanation("Asymptotes are lines that the hyperbola approaches, with slope b/a\n")
    appendBigBlueBoldExplanation("Asymptotes: y$k1 = ±${doubleToFraction(slope)}(x$h1)\n\n")
}

fun explainHyperbolaVertical(a: Double, b: Double, c: Double, d: Double, e: Double) {
    val h = 0 - (b / (2 * a))
    val k = 0 - (d / (2 * c))
    val cleanh = if (h == -0.0) 0.0 else h
    val cleank = if (k == -0.0) 0.0 else k
    val aa = abs(((0 - e) + ((b * b) / (4 * a)) - ((d * d) / (4 * (0 - c)))) / c)
    val bb = abs(((0 - e) + ((b * b) / (4 * a)) - ((d * d) / (4 * (0 - c)))) / a)
    val aNew = sqrt(aa)
    val bNew = sqrt(bb)
    val cNew = sqrt(aa + bb)
    val slope = aNew / bNew

    val bNewCoeff = b / a
    val dNewCoeff = d / c
    val eNewCoeff = e / a
    val completingX = (bNewCoeff / 2).pow(2)
    val completingY = (dNewCoeff / 2).pow(2)

    val hF = doubleToFraction(cleanh)
    val kF = doubleToFraction(cleank)

    val h1: String = if (h > 0) {
        " - $hF"
    } else if (h < 0) {
        " + ${doubleToPositiveFraction(h)}"
    } else {
        ""
    }

    val k1: String = if (k > 0) {
        " - $kF"
    } else if (k < 0) {
        " + ${doubleToPositiveFraction(k)}"
    } else {
        ""
    }

    appendBigBoldExplanation("Explanation:\n")
    appendBigBlueBoldExplanation("It is a Hyperbola!\n")
    appendNormalExplanation("Since A and C have opposite signs, and the discriminant condition is met\n\n")

    appendBigBoldExplanation("Step 1: We will get the standard formula of the hyperbola\n")
    appendNormalExplanation("Group the x² and x terms together, and y² and y terms together, while moving the constant to the right side\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)})\n\n")

    appendBigBoldExplanation("Step 2: Complete the square for x terms\n")
    appendNormalExplanation("To complete the square for Ax² + Bx, add (B/2A)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y = 0 - (${doubleToFraction(e)}) + (${doubleToFraction(completingX)})\n\n")

    appendBigBoldExplanation("Step 3: Complete the square for y terms\n")
    appendNormalExplanation("To complete the square for Cy² + Dy, add (D/2C)² to both sides\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})x² + (${doubleToFraction(b)})x + (${doubleToFraction(completingX)}) + (${doubleToFraction(c)})y² + (${doubleToFraction(d)})y + (${doubleToFraction(completingY)}) = 0 - (${doubleToFraction(e)}) + (${completingX}) + (${completingY})\n\n")

    appendBigBoldExplanation("Step 4: Rewrite as perfect squares and factor\n")
    appendNormalExplanation("Factor the x and y terms into perfect squares\n")
    appendBigBlueBoldExplanation("(${doubleToFraction(a)})(x + (${doubleToFraction(b/(2*a))}))² + (${doubleToFraction(c)})(y + (${doubleToFraction(d/(2*c))}))² = ${doubleToFraction((0 - e) + completingX + completingY)}\n\n")

    appendBigBoldExplanation("Step 5: Divide both sides by the constant to get the standard form\n")
    appendNormalExplanation("Divide the entire equation by the right-hand side constant to make it equal to 1\n")
    appendBigBlueBoldExplanation("(y$k1)²/(${doubleToFraction(aa)}) - (x$h1)²/(${doubleToFraction(bb)}) = 1\n\n")

    appendBigBoldExplanation("Step 6: Now that we have the standard form, we can get the properties of the hyperbola\n")
    appendNormalExplanation("Since the y² term is positive and x² is negative, the transverse axis is vertical\n\n")

    appendBigBoldExplanation("Transverse axis\n")
    appendNormalExplanation("The transverse axis is the line joining the vertices, vertical in this case\n")
    appendBigBlueBoldExplanation("Transverse axis: Vertical, x = $hF\n\n")

    appendBigBoldExplanation("Center of the hyperbola\n")
    appendNormalExplanation("The center is the point (h, k) from the standard form\n")
    appendBigBlueBoldExplanation("Center: ($hF, $kF)\n\n")

    appendBigBoldExplanation("Vertices\n")
    appendNormalExplanation("Vertices are the endpoints of the transverse axis\n")
    appendBigBlueBoldExplanation("Vertices: (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + aNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - aNew)})\n\n")

    appendBigBoldExplanation("Foci\n")
    appendNormalExplanation("Foci are located along the transverse axis, at a distance c from the center\n")
    appendBigBlueBoldExplanation("Foci: (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank + cNew)}) and (${doubleToFraction(cleanh)}, ${doubleToFraction(cleank - cNew)})\n\n")

    appendBigBoldExplanation("Asymptotes\n")
    appendNormalExplanation("Asymptotes are lines that the hyperbola approaches, with slope a/b\n")
    appendBigBlueBoldExplanation("Asymptotes: y$k1 = ±${doubleToFraction(slope)}(x$h1)\n\n")
}
