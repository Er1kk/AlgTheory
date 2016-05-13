package AVLTree;

public class AVL <Key extends Comparable<Key>, Value> {

        //Внутренний класс - узел дерева
        public class Node {
            private int h;          //Высота
            private int balance;    //Баланс
            Key key;                //Ключ
            Value value;            //Значение
            private Node left, right, father; //Узлы-потомки и родитель
            public Node (Key key, Value value, Node father) {
                this.key = key;
                this.value = value;
                this.left = this.right = null;
                this.father = father;
                this.h = 1;
                this.balance = 0;
            }
            //Получить ближайшый узел cо значением ключа большим, чем у данного
            public Node next(){
                return getHigherNode(this.key);
            }
            //Получить ближайшый узел cо значением ключа большим, чем у данного
            public Node previus(){
                return getLowerNode(this.key);
            }
        }

    private Node root;

    //Возвращает ближайщий узел , больше данного ключа,
    //если узла с таким ключом нет, то возвращает ближайщий узел, больше заданного ключа.
    //Если нет ближайщего, большего по значению,чем заданый ключ, то возвращает null
    private Node getHigherNode(Key key) {
        Node p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if (cmp < 0) {
                if (p.left != null)
                    p = p.left;
                else
                    return p;
            } else {
                if (p.right != null) {
                    p = p.right;
                } else {
                    Node father = p.father;
                    Node ch = p;
                    while (father != null && ch == father.right) {
                        ch = father;
                        father = father.father;
                    }
                    return father;
                }
            }
        }
        return null;
    }

    //Возвращает ближайщий узел, меньше данного ключа,
    //если узла с таким ключом нет, то возвращает ближайщий узел, меньше заданного ключа.
    //Если нет ближайщего, большего по значению,чем заданый ключ, то возвращает null
    private Node getLowerNode(Key key) {
        Node p = root;
        while (p != null) {
            int cmp = key.compareTo(p.key);
            if (cmp > 0) {
                if (p.right != null)
                    p = p.right;
                else
                    return p;
            } else {
                if (p.left != null) {
                    p = p.left;
                } else {
                    Node father = p.father;
                    Node ch = p;
                    while (father != null && ch == father.left) {
                        ch = father;
                        father = father.father;
                    }
                    return father;
                }
            }
        }
        return null;
    }

    //Получение самого левого узла
    public Node getFirstNode(){
        return min(root);
    }

    //Получение самого правого узла
    public Node getLastNode(){
        return max(root);
    }

    //Вычисление показателя высоты
    private int height(Node x, Node y){
        if(x == null && y == null) return 0;
        else if(x == null) return y.h;
        else if(y == null) return x.h;
        else return Math.max(x.h, y.h);
    }

    //Вычисление показателя сбалансированнности
    private int balance(Node x, Node y){
        if(x == null && y == null) return 0;
        else if(x == null) return - y.h;
        else if(y == null) return x.h;
        else return x.h - y.h;
    }

    //Вставка записи по ключу и последующая ребалансировка
    private Node add (Node node,Key key, Value value, Node father){
        //Условие, при котором происходит выход из рекурсии и вставка нового узла
        if (node == null){
            Node newnode = new Node(key,value, father);
            return newnode;
        }
        int compareResult = key.compareTo(node.key);
        if (compareResult > 0){node.right = add(node.right, key, value, node); node.h = height(node.left, node.right) + 1;}
        else if(compareResult < 0){node.left = add(node.left, key, value, node); node.h = height(node.left, node.right) + 1;}
        else{
            node.value = value;
        }
        //Балансировка - вычисление значения сбалансированности и повороты
        node.balance = balance(node.left, node.right);
        if(node.balance == -2){
            node = leftRotation(node);
        }else if(node.balance == 2){
            node = rightRotation(node);
        }
        return node;
    }

    //Реализует большое и малое левое вращение
    private Node leftRotation(Node node) {
        if(node.right.right == null && node.right.left != null){
            node.right = rightRotation(node.right);
            node = leftRotation(node);
        }else if(node.right.left == null || node.right.left.h <= node.right.right.h){
            Node newnode = node.right;
            newnode.father = node.father;
            node.right = newnode.left;
            if(node.right != null)
                node.right.father = node;
            node.h = height(node.left, node.right)+1;
            node.father = newnode;
            node.balance = balance(node.left, node.right);
            newnode.left = node;
            node = newnode;
            node.balance = balance(node.left, node.right);
            node.h = height(node.left, node.right)+1;
        }else{
            node.right = rightRotation(node.right);
            node = leftRotation(node);
        }
        return node;
    }

    //Реализует большое и малое правое вращение
    private Node rightRotation(Node node){
        if(node.left.right != null && node.left.left == null){
            node.left = leftRotation(node.left);
            node = rightRotation(node);
        }else if(node.left.right == null || node.left.right.h <= node.left.left.h){
            Node newnode = node.left;
            newnode.father = node.father;
            node.left = newnode.right;
            if(node.left != null)
                node.left.father = node;
            node.h = height(node.left, node.right)+1;
            node.father = newnode;
            node.balance = balance(node.left, node.right);
            newnode.right = node;
            node = newnode;
            node.balance = balance(node.left, node.right);
            node.h = height(node.left, node.right)+1;
        }else{
            node.left = leftRotation(node.left);
            node = rightRotation(node);
        }
        return node;
    }

    //Метод доступа к вставке записи по ключу
    public void add(Key key, Value value) {
        root = add(root, key, value, null);
    }

    //Удаление записи из дерева по ключу и последующая ребалансировка
    private Node delete(Node node, Key key){
        if(node == null) return null;
        int compareResult = key.compareTo(node.key);
        if(compareResult > 0){
            node.right = delete(node.right, key);
        }else if(compareResult < 0){
            node.left = delete(node.left, key);
        }else{
            if(node.right == null && node.left == null){
                node = null;
            }else if(node.right == null){
                node.left.father = node.father;
                node = node.left;
            }else if(node.left == null){
                node.right.father = node.father;
                node = node.right;
            }else{
                if(node.right.left == null){
                    node.right.left = node.left;
                    node.right.father = node.father;
                    node.right.father = node.father;
                    node.left.father = node.right;
                    node = node.right;
                }else{
                    Node res = min(node.right);
                    node.key = res.key;
                    node.value = res.value;
                    delete(node.right, node.key);
                }
            }
        }
        if(node != null) {
            node.h = height(node.left, node.right) + 1;
            node.balance = balance(node.left, node.right);
            if (node.balance == -2) {
                node = leftRotation(node);
            } else if (node.balance == 2) {
                node = rightRotation(node);
            }
        }
        return node;
    }

    //Метод доступа к удалению записи по ключу
    public void delete(Key key) {
        root = delete(root, key);
    }

    //Доступ к нахождению наименьшего ключа
    public Key minKey(){
        return min(root).key;
    }

    //Доступ к нахожлению наибольшего ключа
    public Key maxKey(){
        return max(root).key;
    }

    //Нахождение наименьшего (самого левого) узла
    private Node min(Node node){
        if(node.left == null) return node;
        return min(node.left);
    }

    //Нахождение наибольшего (самого правого) узла
    private Node max(Node node){
        if(node.right == null) return node;
        return max(node.right);
    }

    //Нахождение записи в дереве по ключу
    private Value get(Node node, Key key){
        if(node == null) return null;
        int compareResult = key.compareTo(node.key);
        if(compareResult == 0){
            return node.value;
        }else if(compareResult > 0){
            return get(node.right, key);
        }else{
            return get(node.left, key);
        }
    }

    //Доступ к методу получения записи по ключу
    public Value get(Key key) {
        return get(root, key);
    }

    //Рекурсивный вывод узлов дерева в консоль
    //Вывод - построчно, от правых узлов к левым
    //Высота узла дополнительно визуализируется с помощью табуляции
    private void print(Node node, int level) {
        if (node != null) {
            print(node.right,level+1);
            for (int i=0;i<level;i++) {
                System.out.print("\t");
            }
            System.out.println(node.key + "->" + node.value+" высота="+node.h+" баланс="+node.balance);
            print(node.left,level+1);
        }
    }

    //Доступ к выводу дерева в консоль
    public void print() {
        System.out.println("Вывод узлов дерева: ");
        print(root,0);
    }
}
