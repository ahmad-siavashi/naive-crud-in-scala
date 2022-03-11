// Use H2Profile to connect to an H2 database
import slick.jdbc.H2Profile.api._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Await
import scala.concurrent.duration.Duration

// Definition of the People table (the alternative is to use the code generator)
class People(tag: Tag)
    extends Table[(Int, String, String, Int)](tag, "PEOPLE") {
  def id = column[Int]("ID", O.PrimaryKey) // This is the primary key column
  def firstName = column[String]("FIRST_NAME")
  def lastName = column[String]("LAST_NAME")
  def age = column[Int]("AGE")
  // Every table needs a * projection with the same type as the table's type parameter
  def * = (id, firstName, lastName, age)
}

object Main extends App {
  val people = TableQuery[People]
  val db = Database.forConfig("h2mem1")
  try {
    val setup = DBIO.seq(
      // Create the tables
      (people.schema).create,
      // Insert some persons
      people ++= Seq(
        (0, "Ali", "Rashidi", 25),
        (1, "Reza", "Javadi", 35),
        (2, "Narges", "Jamshidi", 27)
      )
    )
    Await.result(db.run(setup), Duration.Inf)
    // Read all people
    Await.result(
      db.run(people.result)
        .map(_.foreach { case (id, firstName, lastName, age) =>
          println(s"$firstName $lastName is $age years old.")
        }),
      Duration.Inf
    )
  } catch {
    case e: Throwable => print(e.printStackTrace())
  } finally db.close
}
