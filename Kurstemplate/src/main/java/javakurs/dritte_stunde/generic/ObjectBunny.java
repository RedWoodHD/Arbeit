package javakurs.dritte_stunde.generic;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ObjectBunny<E>
{
    E element;
    ObjectBunny<E> nachfolger;
}
