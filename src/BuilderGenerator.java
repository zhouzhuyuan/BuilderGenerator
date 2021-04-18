import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiClass;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiField;
import com.intellij.psi.PsiFile;
import com.intellij.psi.util.PsiUtilBase;

public class BuilderGenerator extends AnAction {

    @Override
    public void actionPerformed(AnActionEvent actionEvent) {
        Project project = actionEvent.getProject();
        if (project != null) {
            Editor editor = actionEvent.getRequiredData(CommonDataKeys.EDITOR);
            PsiFile file = PsiUtilBase.getPsiFileInEditor(editor, project);
            if (file != null) {
                for (PsiElement element : file.getChildren()) {
                    System.out.println("element:" + element);
                    if (element instanceof PsiClass) {
                        PsiClass fileClass = (PsiClass) element;
                        for (PsiField field : fileClass.getFields()) {
                            System.out.println("filed:" + field.getName());
                        }
                    }
                }
            }
        }
    }
}
