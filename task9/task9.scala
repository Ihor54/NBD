object Assignment9 {
  def main(args: Array[String]) = {

    var p = new Container[String]("fjfj")
    println(p.getContent)
    def test(s:String):String ={
        s + "1231"
    }
    
    println(p.applyFunction[String](test))

    var no: No = new No()
    var yes: Yes[String] = new Yes[String]("aaa")
    println("no.isInstanceOf(Maybe[_]):" + no.isInstanceOf[Maybe[_]])
    println("yes.isInstanceOf(Maybe[_]):" + no.isInstanceOf[Maybe[_]])
    
    val yes2 = yes.applyFunction[String](test)
    println(yes2.getOrElse("f"))
    
    val no2 = no.applyFunction[String](test)
    println(no2.isInstanceOf[No])
  }

}

class Container[A](private val value:A){
    def getContent:A = value

    def applyFunction[R](f:(A) => R):R = {
        f(value)
    }
}

trait Maybe[A]{
    def applyFunction[R](f:(A) => R):Maybe[_]
    def getOrElse[B>:A](v: B):B
}

class No extends Maybe[Nothing]{
    override def applyFunction[R](f:Nothing => R):No ={
        new No()
    }
  
    override def getOrElse[B](p:B): B = p
}

class Yes[A](var p:A) extends Maybe[A]{
    override def applyFunction[R](f:(A) => R):Yes[R] ={
        val p1 = f(p)
        new Yes[R](p1)
    }
    override def getOrElse[B>:A](p:B):B = p
}
 