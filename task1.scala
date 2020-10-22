 import scala.annotation.tailrec

//task 1.	Create a 7 element list with names of days of the week. Create a function returning a string with comma-separated list elements using:
val list = List("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")
//a.	for loop
def concatList(days: List[String]): String = {
  var result = ""
  var isFirst = false
  for(day <- days){
    if(!isFirst) {
      result = result + day
      isFirst = true
    }
    else result =  result + ", " + day
  }
  result
}

//b.	for loop, the string should contain only days with names starting with “S”
def concatListStartS(days: List[String]): String = {
  var result = ""
  var isFirst = false
  for(day <- days if day.startsWith("S")){
     if(!isFirst) {
       result = result + day
       isFirst = true
     }
      else result =  result + ", " + day
  }
  result
}

//c.	while loop
def concatListWhile(days: List[String]): String = {
  var result = ""
  var i = 0
  while(i < days.length){
    if(i == 0) result = result + days(i)
    else result = result + ", " + days(i)
    i = i + 1
  }
  result
}

println(concatList(list))
println(concatListStartS(list))
println(concatListWhile(list))

//task 2.	For list from #1 create a function returning a string with comma-separated list elements using:
//a.	recursive function
def iterateRecursive(l: List[String]): String={
  if(l.isEmpty) ""
  else l.head + ", " + iterateRecursive(l.tail)
}
//b.	recursive function, list elements should be printed from last to first
def iterateRecursiveEnd(l: List[String]): String={
  if(l.isEmpty) ""
  else iterateRecursiveEnd(l.tail) + l.head + ", "
}

println(iterateRecursive(list))
println(iterateRecursiveEnd(list))

//task 3.	Create a tail-recursive function returning a comma-separated string using list from #1
@tailrec
def iterateTailRecursive(l: List[String], acc: String): String={
  if(l.isEmpty) acc
  else iterateTailRecursive(l.tail, acc + l.head + ", ")
}

println(iterateTailRecursive(list, ""))

//task 4.	For list from #1 create a function returning a string with comma-separated list elements using:
//a.	foldl
def foldlConcatList(l: List[String]): String={
  l.foldLeft("")(_ + _ + ", ")
}
//b.	foldr
def foldrConcatList(l: List[String]): String={
  l.foldRight("")(_ + ", "+ _ )
}
//c.	foldl, the string should contain only days with names starting with “S”
    def foldlStartSConcatList(l: List[String]): String={
      l.foldLeft("")((acc, i) => {
        if(i.startsWith("S")) acc + i + ", "
        else acc
      })
    }

println(foldlConcatList(list))
println(foldrConcatList(list))
println(foldlStartSConcatList(list))

//task 5.	Create a map with several product names (keys) and their prices (values). Based on this create a second map with 10% price reduction. Use collection mapping
val products = Map("Milk" -> 5, "Wine" -> 20, "Bread" -> 3, "Cheese" -> 10)
val updatedProducts = products.map{case (k, v) => (k, v - (v * 0.1))}
println(products)
println(updatedProducts)

//task 6. Define a function accepting a list of integers and returning another list with all values increased by 1. Use collection mapping
val ints = List(1,2,3,4,5,6,7,8,9,10)
val updatedInts = ints.map(i => i + 1)
val updatedInts2 = ints.map(_ + 1)
println(ints)
println(updatedInts)

//task 7. Create a function accepting a list of real numbers and returning a new list, containing absolute values of elements of original list with values in the <-5,12> range

val realNums = List(-1.2, 2.67, -5.8, 7.1)
def absolute(list: List[Double]): List[Double]={
    list.filter(i => i >= -5 && i <= 12).map(_.abs)
}

println(absolute(realNums))

//task 8.	Define a function accepting tuple with 3 values of different types and printing it
val t = (1, "x3", 2.0)
def printTuple(t: Tuple3[Any, Any, Any])={
  println(t._1.toString + " " + t._2.toString + " "+ t._3.toString)
}
printTuple(t)               

//task 9.	Write function accepting a list and resulting the same list without values equal to 0. Do this using recursion.
val listInts = List(1,0,3,0,4,2,3,0)
def recursiveZeroRemoval(l: List[Int]): List[Int]={
  if(l.isEmpty) List()
  else {
    if(l.head != 0) l.head :: recursiveZeroRemoval(l.tail)
    else recursiveZeroRemoval(l.tail)
  }
}

println(recursiveZeroRemoval(listInts))

//task 10.	Present the use of Option (come up with an example, use at least 2 different Option methods)
//example 1
val bagStrings = List("1", "4", "bag", "notInt", "10")

def toInt(s: String): Option[Int] = {
  try {
    Some(s.toInt)
  } catch {
    case e: Exception => None
  }
}
val opts = bagStrings.map(toInt(_))

println(opts.map(_.getOrElse(0)))

//example 2
println(products.get("Nuts").getOrElse("0"))
println(products.get("Wine").getOrElse("0"))

