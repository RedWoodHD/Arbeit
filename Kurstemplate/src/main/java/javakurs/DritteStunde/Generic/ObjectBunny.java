package javakurs.DritteStunde.Generic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ObjectBunny<E>
{
    E element;
    ObjectBunny<E> nachfolger;
}
