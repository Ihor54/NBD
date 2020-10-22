//task 1. Use pattern matching in a function accepting a String. For strings containing names of days of the week 
//        return “work” (Monday-Friday) or “weekend” ( for weekends). For all other strings return “no such day”

def daysOfWeek(s:String):String = {
    s match {
        case "Monday" | "Tuesday" | "Wednesday" | "Thursday" | "Friday" => "work"
        case "Saturday" | "Sunday" => "weekend"
        case _ => "no such day"
    }
}
    
println(daysOfWeek("Monday"))
println(daysOfWeek("Sunday"))
println(daysOfWeek("something"))

//task 2. Define a BankAccount class with methods deposits and withdraw and currentBalance read only property. 
//        The class should provide a constructor accepting initial balance and second constructor, setting the balance to 0.

class BankAccount(initialBalance:Double){

    def this() = {
      this(0.0)
    }
  
    private var _currentBalance:Double = 0
    def currentBalance = _currentBalance
  
    _currentBalance = initialBalance
    def deposit(amount:Double)={
        _currentBalance = _currentBalance + amount
    }

    def withdraw(amount:Double)={
        _currentBalance = _currentBalance - amount
    }

}

val acc = new BankAccount(1000)
println(acc.currentBalance)
acc.deposit(200)
println(acc.currentBalance)
acc.withdraw(100)
println(acc.currentBalance)

val acc1 = new BankAccount()
println(acc1.currentBalance)

//task 3. Define a Person class with properties firstName and lastName. Create a few instances. Define a function accepting Person instance
//        and using pattern matching to select string greeting the person. Define 2-3 different greetings for people meeting specific criteria
//        (eg. specific first or last name) and one generic greeting

case class Person(var firstName: String, var lastName:String){}

var p1 = new Person("Bob", "Brown")
var p2 = new Person("John", "Trump")
var p3 = new Person("Bobby", "Snake")
var p4 = new Person("Tom", "Snicky")

def greet(p: Person): String = p match{
  case Person("Tom", "Snicky") => "Hi, Tom"
  case Person("Bobby", "Snake") => "Wow, who is this? Hello, Bobby"
  case Person("John", "Trump") => "Almost like a president! Hi, John"
  case Person(firstName, lastName) => s"Hello, $firstName $lastName!!!"
}

println(greet(p1))
println(greet(p2))
println(greet(p3))
println(greet(p4))

//task 4. Define a function accepting two parameters – integer and a function operating on integers. 
//        Apply the parameter function three times to the integer and return a result

def doThreeTimes(i:Int, f:Int => Int) = f(f(f(i)))

println(doThreeTimes(3, n => n * 3))
println(doThreeTimes(64, n => n / 2))

//task 5. Define a Person class and three traits: Student, Teacher, Employee. Person should have firstName, lastName and taxToPay read only properties.
//        Employee should have a salary property (with getter and setter). Student and Employee traits should override taxToPay property – 
//        for Student it should return 0, for Employee it should return 20% of his salary. 
//        Teacher should inherit from employee, the taxToPay should return 10% of his salary.
//        Create objects with each of the properites, show how their properties work. Create two objects with both the Student and Employee properties 
//        (add them in different order in each object), show how taxToPay will work with this object depending on the order those traits are added upon instantiation.

class Person(val firstName:String, val lastName:String, private var _taxToPay:Double){
  def taxToPay:Double = _taxToPay
}

trait Student extends Person{
    override def taxToPay = {
      0
    }
}
trait Teacher extends Employee{
    override def taxToPay:Double = { salary * 0.1}
}
trait Employee extends Person{
    private var _salary:Double = 0
    def salary = _salary
    def salary_= (value:Double):Unit = _salary = value

    override def taxToPay:Double = { salary * 0.2}
}

var p = new Person("Bob", "Peterson", 100)
println(p.taxToPay)
var s = new Person("Tom", "Snicky", 500) with Student with Employee
s.salary = 1300
println(s.taxToPay)
 var e = new Person("Tom", "Snicky", 400) with Employee with Student
println(e.taxToPay)
e.salary = 1000
println(e.taxToPay)
var t = new Person("Tom", "Snicky", 400) with Teacher
println(t.taxToPay)
t.salary = 1500
println(t.taxToPay)
