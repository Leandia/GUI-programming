package backend;

import java.util.ArrayList;
import javax.swing.AbstractListModel;

/**
 *
 * @author Kristian
 */
public class CategoryListModel extends AbstractListModel {

    private ArrayList<Category> list = new ArrayList();
    
    public CategoryListModel(){
        
    }
    
    @Override
    public int getSize() {
        return this.list.size();
    }

    @Override
    public Object getElementAt(int i) {
        return this.list.get(i).getCategoryTitle();
    }
    
    public ArrayList<Category> getList(){
        return this.list;
    }
    
    protected void addCategory(Category category){
        this.list.add(category);
        this.fireContentsChanged(this, 0, this.list.size());
    }
    
    protected void removeCategory(Category category){
        this.list.remove(category);
        this.fireContentsChanged(this, 0, this.list.size());
    }
    
    protected void setList(ArrayList<Category> categories){
        for(int i=0;i<categories.size();i++){
            this.list.add(categories.get(i));
        }
        this.fireContentsChanged(this, 0, this.list.size());
    }
}
