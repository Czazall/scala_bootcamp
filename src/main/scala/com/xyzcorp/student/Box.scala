package com.xyzcorp.student

class Box[A](a:A)
{
    def tupleItWith[B](b:B):Box[(A, B)] = 
    {
        new Box(a,b)
    }
}