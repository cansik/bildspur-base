package ch.bildspur.model


open class ListDataModel<T>(items : MutableList<T> = mutableListOf(), override val size: Int = items.size) : DataModel<MutableList<T>>(items), MutableCollection<T> {

    override fun contains(element: T): Boolean {
        return value.contains(element)
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return value.containsAll(elements)
    }

    override fun isEmpty(): Boolean {
        return value.isEmpty()
    }

    override fun add(element: T): Boolean {
        val returnValue = value.add(element)

        if(returnValue)
            this.fire()

        return returnValue
    }

    override fun addAll(elements: Collection<T>): Boolean {
        val returnValue = value.addAll(elements)

        if(returnValue)
            this.fire()

        return returnValue
    }

    override fun clear() {
        value.clear()
        this.fire()
    }

    override fun iterator(): MutableIterator<T> {
        return value.iterator()
    }

    override fun remove(element: T): Boolean {
        val returnValue = value.remove(element)

        if(returnValue)
            this.fire()

        return returnValue
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        val returnValue = value.removeAll(elements)

        if(returnValue)
            this.fire()

        return returnValue
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        val returnValue = value.retainAll(elements)

        if(returnValue)
            this.fire()

        return returnValue
    }

    override fun toString(): String {
        return "ListDataModel (${value.size})"
    }
}