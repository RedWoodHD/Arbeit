package javakurs.VierteStunde.anonymousfilter;

public abstract class AnonymousFilter
{
   protected abstract boolean filter1(final int elementToCheck);

   protected abstract boolean filter2(final int elementToCheck);

   protected abstract FilterConjunctionEnum filterConjunction();
}
