import converter.*

case class User(id: Long, name: String)
case class UserDto(id: Long, name: String)

given Converter[User, UserDto] with
  def convert(value: User): UserDto = UserDto(value.id, value.name)

@main def run(): Unit =
  val user = User(1L, "John")
  val dto = user.convertTo[UserDto]
  println(s"User: $user")
  println(s"DTO: $dto")

  val users = List(User(1L, "Alice"), User(2L, "Bob"))
  val dtos = users.convertTo[List[UserDto]]
  println(s"DTOs: $dtos")
