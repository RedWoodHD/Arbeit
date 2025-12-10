package javakurs.Hausaufgaben.HA3;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

/**
 * "Einfache" Graphimplementierung mittels Inzidenzlisten. In dieser Implementierung können sowohl die Knoten als auch
 * die Kanten jeweils homogene Typen als Werte haben. Löschoperationen werden in dieser simplen Implementierung nicht
 * unterstützt.
 *
 * @param <V> Der Wertetyp der Knoten
 * @param <E> Der Wertetyp der Kanten
 */
public final class Graph<V, E> {

    /**
     * Die Knotenliste
     */
    private final List<Vertex> vertices = new ArrayList<>();

    /**
     * Die Kantenliste
     */
    private final List<Edge> edges = new ArrayList<>();

    /**
     * Die nächste freie Knoten-ID
     */
    private int nextVertexId = 1;

    /**
     * Die nächste freie Kanten-ID
     */
    private int nextEdgeId = 1;

    /**
     * Innere Knotenklasse.
     */
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public final class Vertex {

        /**
         * Die eindeutige ID des Knotens.
         */
        @Getter
        final int id;

        /**
         * Der Wert des Knotens.
         */
        @Getter
        final V value;

        /**
         * Die Inzidenzliste der eingehenden Kanten.
         */
        final List<Edge> incidencesIn = new ArrayList<>();

        /**
         * Die Inzidenzliste der ausgehenden Kanten.
         */
        final List<Edge> incidencesOut = new ArrayList<>();

        /**
         * Liefert einen Stream der eingehenden Kanten. Das ist übrigens auch eine Möglichkeit eine Liste "read-only"
         * herauszugeben.
         */
        public Stream<Edge> getIncidenceInStream() {
            return incidencesIn.stream();
        }

        /**
         * Liefert einen Stream der ausgehenden Kanten. Das ist übrigens auch eine Möglichkeit eine Liste "read-only"
         * herauszugeben.
         */
        public Stream<Edge> getIncidenceOutStream() {
            return incidencesOut.stream();
        }

        /**
         * Liefert das Graph-Objekt, zu dem dieser Knoten gehört.
         */
        public Graph<V, E> getGraph() {
            return Graph.this;
        }
    }

    /**
     * Innere Kantenklasse zur Repräsentation gerichteter Kanten.
     */
    @Getter
    @RequiredArgsConstructor(access = AccessLevel.PRIVATE)
    public class Edge {
        /**
         * Die ID der Kante.
         */
        final int id;

        /**
         * Der Startknoten dieser Kante.
         */
        final Vertex alpha;

        /**
         * Der Endknoten dieser Kante.
         */
        final Vertex omega;

        /**
         * Der Wert dieser Kante.
         */
        final E value;

        /**
         * Liefert das Graph-Objekt, zu dem diese Kante gehört.
         */
        public Graph<V, E> getGraph() {
            return Graph.this;
        }
    }

    /**
     * Erzeugt einen Knoten und fügt ihn diesem Graphen hinzu. Initial wird dieser Knoten isoliert sein.
     */
    public Vertex createVertex(final V value) {
        if (value == null) {
            throw new IllegalArgumentException("Value must not be null.");
        }
        final Vertex newVertex = new Vertex(nextVertexId, value);
        vertices.add(newVertex);
        nextVertexId += 1;
        return newVertex;
    }

    /**
     * Liefert den Knoten zur übergebenen ID. Liefert null, falls es keinen gibt.
     */
    public Vertex getVertex(final int vertexId) {
        final int vertexIndex = vertexId - 1;
        if (vertexIndex < 0 || vertexIndex >= vertices.size()) {
            return null;
        }
        return vertices.get(vertexIndex);
    }

    /**
     * Liefert einen Stream aller Knoten. Das ist übrigens auch eine Möglichkeit eine Liste "read-only"
     * herauszugeben.
     */
    public Stream<Vertex> getVertexStream() {
        return vertices.stream();
    }

    /**
     * Gibt an, wie viele Knoten im Graphen enthalten sind.
     */
    public int countVertices() {
        return vertices.size();
    }

    /**
     * Erzeugt eine neue Kante und fügt sie diesem Graphen hinzu. Es müssen der Alpha-Knoten, der Omega-Knoten und der
     * Wert der Kante angegeben werden. Die beteiligten Knoten müssen Teil dieses Graphen sein.
     */
    public Edge createEdge(final Vertex alpha, final Vertex omega, final E value) {
        if (alpha == null || omega == null || value == null) {
            throw new IllegalArgumentException("Alpha, omega, and value must not be null.");
        }
        if (alpha.getGraph() != this || omega.getGraph() != this) {
            throw new IllegalArgumentException("The vertices have to be part of this graph.");
        }
        final Edge newEdge = new Edge(nextEdgeId, alpha, omega, value);
        edges.add(newEdge);
        // Inzidenzlisten pflegen
        alpha.incidencesOut.add(newEdge);
        omega.incidencesIn.add(newEdge);
        // ---
        nextEdgeId += 1;
        return newEdge;
    }

    /**
     * Erzeugt eine neue Kante und fügt sie diesem Graphen hinzu. Es müssen die IDs des Alpha-Knotens, die ID des Omega-
     * Knotens und der Wert der Kante angegeben werden. Es muss zu beiden IDs ein Knoten in diesem Graphen existieren.
     */
    public Edge createEdge(final int alphaId, final int omegaId, final E value) {
        final Vertex alpha = getVertex(alphaId);
        final Vertex omega = getVertex(omegaId);
        return createEdge(alpha, omega, value);
    }

    /**
     * Liefert die Kante zur übergebenen ID. Liefert null, falls es keine gibt.
     */
    public Edge getEdge(final int edgeId) {
        final int edgeIndex = edgeId - 1;
        if (edgeIndex < 0 || edgeIndex >= edges.size()) {
            return null;
        }
        return edges.get(edgeIndex);
    }

    /**
     * Liefert einen Stream aller Kanten. Das ist übrigens auch eine Möglichkeit eine Liste "read-only"
     * herauszugeben.
     */
    public Stream<Edge> getEdgeStream() {
        return edges.stream();
    }

    /**
     * Gibt an, wie viele Kanten im Graphen enthalten sind.
     */
    public int countEdges() {
        return edges.size();
    }

}