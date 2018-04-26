package com.xyzcorp.student

case class Box[A](a:A)
{
    def tupleItWith[B](b:B):Box[(A, B)] = 
    {
        new Box(a,b)
    }

    def map[B](f:A => B) = new Box(f(a))

    def flatMap[B](f: A=> Box[B]) = new Box(f(a).a)
}