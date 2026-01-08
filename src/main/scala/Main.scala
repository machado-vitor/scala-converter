import converter.*

case class User(id: Long, name: String)
case class UserDto(id: Long, name: String)

// The type class(Converter) defines what operations exist.
// The given instance define how they work for specific types.
given Converter[User, UserDto] with
  def convert(value: User): UserDto = UserDto(value.id, value.name)

@main def run(): Unit =
  val user = User(1L, "John")
  val dto = user.convertTo[UserDto] // the compiler rewrites user.convertTo[UserDto] into the extension method call.
  println(s"User: $user")
  println(s"DTO: $dto")

  val users = List(User(1L, "Alice"), User(2L, "Bob"))
  val dtos = users.convertTo[List[UserDto]]
  println(s"DTOs: $dtos")

  val maybeUser: Option[User] = Some(User(3L, "Charlie"))
  val maybeDto = maybeUser.convertTo[Option[UserDto]]
  println(s"Maybe DTO: $maybeDto")

  val eitherUser: Either[String, User] = Right(User(4L, "Diana"))
  val eitherDto = eitherUser.convertTo[Either[String, UserDto]]
  println(s"Either DTO: $eitherDto")
