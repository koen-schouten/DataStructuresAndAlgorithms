package Tree;


import PositionalList.IPosition;

public abstract class AbstractTree<E> implements ITree<E> {
    @Override
    public boolean isInternal(IPosition<E> p){
        return (numChildren(p) > 0);
    }

    @Override
    public boolean isExternal(IPosition<E> p){
        return (numChildren(p) == 0);
    }

    @Override
    public boolean isRoot(IPosition<E> p){
        return p == root();
    }

    @Override
    public boolean isEmpty() {
        return size() == 0;
    }
}
