package converter
// Converter is a type class, it defines behavior separately from data types.

trait Converter[A, B]:
  def convert(value: A): B

object Converter:
  given listConverter[A, B](using c: Converter[A, B]): Converter[List[A], List[B]] with
    def convert(value: List[A]): List[B] = value.map(c.convert)

  given optionConverter[A, B](using c: Converter[A, B]): Converter[Option[A], Option[B]] with
    def convert(value: Option[A]): Option[B] = value.map(c.convert)

extension [A](value: A)
  def convertTo[B](using c: Converter[A, B]): B = c.convert(value)
// extension adds convertTo methods to every type A.