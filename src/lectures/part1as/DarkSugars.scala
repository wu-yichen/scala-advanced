package lectures.part1as

object DarkSugars extends App {

  // syntax sugar #1: methods with single param
  def singleArgMethod(arg: Int): String = s"$arg little ducks..."

  val description = singleArgMethod {
    // write some complex code
    42
  }

  // 2 single abstract method
  trait Action {
    def act(x: Int): Int
  }

  val anInstance: Action = new Action {
    override def act(x: Int): Int = x + 1
  }

  val aFunkyInstance: Action = (x: Int) => x + 1

  abstract class AnAbstractType {
    def implemented = 23

    def unImpl(x: Int): Unit
  }

  val anInstance2: AnAbstractType = x => print(x)

  // the :: and #:: methods are special  right-associative if ending in ":"
  class MyStream[T] {
    def ->:(x: T): MyStream[T] = this
  }

  val result = 1 ->: 2 ->: new MyStream[Int]

  // multi-word method naming
  class TeenGirl(name: String) {
    def `and then said`(what: String) = println(s"$name said $what")
  }

  val lilly = new TeenGirl("lilly")
  lilly `and then said` "scala is so sweet"

  // infix types
  class Composite[A, B]

  //  val composit: Int Composite String = ???
  //  val composit2: Composite[Int, String] = ???

  // update() is very special much like apply()
  val anArray = Array(1, 2, 3)
  anArray(2) = 4 // 1,2,4
  // used in mutable collections
  // remember apply() and update()

  // setter for mutable containers
  class Mutable {
    private var internalMember = 0

    def member = internalMember // getter member
    def member_=(value: Int): Unit = internalMember = value // setter member_=
  }

  val m = new Mutable
  m.member = 42
  println(m.member) // rewrittern as m.member_=(42)

}
