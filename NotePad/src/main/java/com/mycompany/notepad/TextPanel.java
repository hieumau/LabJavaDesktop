/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.notepad;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.WindowConstants;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.text.DefaultEditorKit;
import javax.swing.text.Document;
import javax.swing.undo.CannotRedoException;
import javax.swing.undo.CannotUndoException;
import javax.swing.undo.UndoManager;

/**
 *
 * @author saost
 */
public class TextPanel extends javax.swing.JFrame {

    /**
     * Creates new form demo
     */
    
    public File currentFile;
    public boolean isSaved;
    UndoManager undoManager;
    public TextPanel() {
        initComponents();
        undoAndRedoSetup();
        this.setTitle("Untitled - Notepad");
        currentFile = null;
        isSaved = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        mnNew2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        txt = new javax.swing.JTextArea();
        jMenuBar1 = new javax.swing.JMenuBar();
        mnFile = new javax.swing.JMenu();
        mnNew = new javax.swing.JMenuItem();
        mnOpen = new javax.swing.JMenuItem();
        mnSave = new javax.swing.JMenuItem();
        mnSaveAs = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        mnExit = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        mnSelectAll = new javax.swing.JMenuItem();
        mnCut = new javax.swing.JMenuItem();
        mnCopy = new javax.swing.JMenuItem();
        mnPaste = new javax.swing.JMenuItem();
        mnUndo = new javax.swing.JMenuItem();
        mnRedo = new javax.swing.JMenuItem();
        mnFind = new javax.swing.JMenuItem();
        mnReplace = new javax.swing.JMenuItem();
        mnChangeFont = new javax.swing.JMenuItem();

        mnNew2.setText("New");
        mnNew2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNew2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(mnNew2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                formComponentMoved(evt);
            }
        });
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        txt.setColumns(20);
        txt.setRows(5);
        txt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtMouseClicked(evt);
            }
        });
        txt.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                txtComponentMoved(evt);
            }
        });
        jScrollPane1.setViewportView(txt);

        mnFile.setText("File");
        mnFile.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mnNew.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_MASK));
        mnNew.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnNew.setText("New");
        mnNew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnNewActionPerformed(evt);
            }
        });
        mnFile.add(mnNew);

        mnOpen.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.CTRL_MASK));
        mnOpen.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnOpen.setText("Open");
        mnOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnOpenActionPerformed(evt);
            }
        });
        mnFile.add(mnOpen);

        mnSave.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mnSave.setText("Save");
        mnSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveActionPerformed(evt);
            }
        });
        mnFile.add(mnSave);

        mnSaveAs.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnSaveAs.setText("Save as");
        mnSaveAs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSaveAsActionPerformed(evt);
            }
        });
        mnFile.add(mnSaveAs);
        mnFile.add(jSeparator1);

        mnExit.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_E, java.awt.event.InputEvent.CTRL_MASK));
        mnExit.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        mnExit.setText("Exit");
        mnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnExitActionPerformed(evt);
            }
        });
        mnFile.add(mnExit);

        jMenuBar1.add(mnFile);

        jMenu2.setText("Edit");
        jMenu2.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N

        mnSelectAll.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        mnSelectAll.setText("Select all");
        mnSelectAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnSelectAllActionPerformed(evt);
            }
        });
        jMenu2.add(mnSelectAll);

        mnCut.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_X, java.awt.event.InputEvent.CTRL_MASK));
        mnCut.setText("Cut");
        mnCut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCutActionPerformed(evt);
            }
        });
        jMenu2.add(mnCut);

        mnCopy.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C, java.awt.event.InputEvent.CTRL_MASK));
        mnCopy.setText("Copy");
        mnCopy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnCopyActionPerformed(evt);
            }
        });
        jMenu2.add(mnCopy);

        mnPaste.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_V, java.awt.event.InputEvent.CTRL_MASK));
        mnPaste.setText("Paste");
        mnPaste.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnPasteActionPerformed(evt);
            }
        });
        jMenu2.add(mnPaste);

        mnUndo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_MASK));
        mnUndo.setText("Undo");
        mnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnUndoActionPerformed(evt);
            }
        });
        jMenu2.add(mnUndo);

        mnRedo.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_MASK | java.awt.event.InputEvent.CTRL_MASK));
        mnRedo.setText("Redo");
        mnRedo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnRedoActionPerformed(evt);
            }
        });
        jMenu2.add(mnRedo);

        mnFind.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F, java.awt.event.InputEvent.CTRL_MASK));
        mnFind.setText("Find");
        mnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnFindActionPerformed(evt);
            }
        });
        jMenu2.add(mnFind);

        mnReplace.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        mnReplace.setText("Replace");
        mnReplace.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnReplaceActionPerformed(evt);
            }
        });
        jMenu2.add(mnReplace);

        mnChangeFont.setText("Change Font");
        mnChangeFont.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mnChangeFontActionPerformed(evt);
            }
        });
        jMenu2.add(mnChangeFont);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 384, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mnNewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNewActionPerformed
         // TODO add your handling code here:
        if(currentFile == null){
            if(!txt.getText().equals("")){       
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to save changes to Untitled?", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
                if(ans == JOptionPane.YES_OPTION){
                    if (saveFile()) {
                        txt.setText("");
                    }   
                }
                if(ans == JOptionPane.NO_OPTION){
                    txt.setText("");
                }
            }
        } else {
            if (!isTheSameWithCurrentFile()){
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to save changes to \n " + currentFile.getAbsolutePath() , "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
                if(ans == JOptionPane.YES_OPTION){
                    if (saveFile()) {
                        txt.setText(""); 
                    }  
                    currentFile = null;
                }
                if(ans == JOptionPane.NO_OPTION){
                    txt.setText(""); 
                    currentFile = null;
                }
            } else {
                txt.setText("");
                currentFile = null;
            }
        }
        if (currentFile == null){
            this.setTitle("Untitled - Notepad");
        }
    }//GEN-LAST:event_mnNewActionPerformed

    private void mnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnExitActionPerformed
         // TODO add your handling code here:
        if(currentFile == null){
            if(!txt.getText().equals("")){       
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to save changes to Untitled?", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
                if(ans == JOptionPane.YES_OPTION){
                    if (saveFile()){
                        System.exit(JOptionPane.YES_OPTION);
                    }      
                }
                if(ans == JOptionPane.NO_OPTION){
                    System.exit(JOptionPane.YES_OPTION);
                }
               
            } else {
                System.exit(JOptionPane.YES_OPTION);
            }
        } else {
            if (!isTheSameWithCurrentFile()){
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to save changes to \n " + currentFile.getAbsolutePath() , "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
                if(ans == JOptionPane.YES_OPTION){
                    if (saveFile()){
                        System.exit(JOptionPane.YES_OPTION);
                    } 
                }
                if(ans == JOptionPane.NO_OPTION){
                    System.exit(JOptionPane.YES_OPTION);
                }
            } else {
                System.exit(JOptionPane.YES_OPTION);  
            }
        }   
    }//GEN-LAST:event_mnExitActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
         // TODO add your handling code here:
        
    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        // TODO add your handling code here:
        setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);

        mnExitActionPerformed(null);
  
    }//GEN-LAST:event_formWindowClosing

    private void mnNew2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnNew2ActionPerformed
        // TODO add your handling code here:
        jPopupMenu1.setVisible(false);
        mnNewActionPerformed(null);
        
    }//GEN-LAST:event_mnNew2ActionPerformed

    private void txtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtMouseClicked
        // TODO add your handling code here:
        if(evt.getButton() == 3){
            jPopupMenu1.setLocation(evt.getXOnScreen(), evt.getYOnScreen());
            jPopupMenu1.setVisible(true);
        } else {
            jPopupMenu1.setVisible(false);
        }
    }//GEN-LAST:event_txtMouseClicked

    private void txtComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_txtComponentMoved
        // TODO add your handling code here:
        jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_txtComponentMoved

    private void formComponentMoved(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentMoved
        // TODO add your handling code here:
        jPopupMenu1.setVisible(false);
    }//GEN-LAST:event_formComponentMoved

    private void mnOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnOpenActionPerformed
        // TODO add your handling code here:
        
        if(currentFile == null){
            if(!txt.getText().equals("")){       
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to save changes to Untitled?", "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
                if(ans == JOptionPane.YES_OPTION){
                    mnSaveActionPerformed(null);
                    chooseAndReadTextFile();
                }
                if(ans == JOptionPane.NO_OPTION){
                    chooseAndReadTextFile();
                }
            } else {
                chooseAndReadTextFile();
            }
        } else {
            if (!isTheSameWithCurrentFile()){
                int ans = JOptionPane.showConfirmDialog(null, "Do you want to save changes to \n " + currentFile.getAbsolutePath() , "Notepad", JOptionPane.YES_NO_CANCEL_OPTION);
                if(ans == JOptionPane.YES_OPTION){
                    mnSaveActionPerformed(null);
                    chooseAndReadTextFile();
                }
                if(ans == JOptionPane.NO_OPTION){
                    chooseAndReadTextFile();
                }
            } else {
                chooseAndReadTextFile();
            }
        }       
       
    }//GEN-LAST:event_mnOpenActionPerformed
    
    private void chooseAndReadTextFile(){
        JFileChooser fc = new JFileChooser();
        int choice;
        choice = fc.showOpenDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            currentFile = f;
            this.setTitle(currentFile.getAbsolutePath() + " - Notepad");
            
            try {
                readFile(f);
            } catch (IOException ex) {
                Logger.getLogger(TextPanel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void mnSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveActionPerformed
        // TODO add your handling code here:
        saveFile();
        this.setTitle(currentFile.getAbsolutePath() + " - Notepad");
    }//GEN-LAST:event_mnSaveActionPerformed
    
    private boolean saveFile(){
        if (currentFile == null){
            return saveAsFile();  
        } else {
            if(!isTheSameWithCurrentFile()){
                saveFile(currentFile);
                return true;
            }     
        }
        return false;
    }
    private boolean saveAsFile(){
        JFileChooser fc = new JFileChooser();
        
        int choice = fc.showSaveDialog(null);
        if(choice == JFileChooser.APPROVE_OPTION){
            File f = fc.getSelectedFile();
            if (f.exists()){
                int ans = JOptionPane.showConfirmDialog(null, currentFile.getName() + " already exists.\nDo you want to replace it?", "Confirm Save As", JOptionPane.YES_NO_OPTION);
                if (ans == JOptionPane.YES_OPTION){
                    saveFile(currentFile); 
                    this.setTitle(currentFile.getAbsolutePath() + " - Notepad");
                    return true;
                } else {
                    mnSaveAsActionPerformed(null);
                }
            }
//            if (f.equals(currentFile)){
//                System.out.println("same");
//                int ans = JOptionPane.showConfirmDialog(null, currentFile.getName() + " already exists.\nDo you want to replace it?", "Confirm Save As", JOptionPane.YES_NO_OPTION);
//                if (ans == JOptionPane.YES_OPTION){
//                    saveFile(currentFile); 
//                    this.setTitle(currentFile.getAbsolutePath() + " - Notepad");
//                    return true;
//                } else {
//                    mnSaveAsActionPerformed(null);
//                }
//            } 
            else {
                currentFile = f;
                saveFile(f); 
                this.setTitle(currentFile.getAbsolutePath() + " - Notepad");
                return true;
            } 
        }
        return false;
    }
    private void mnSaveAsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSaveAsActionPerformed
        // TODO add your handling code here:
        saveAsFile();
    }//GEN-LAST:event_mnSaveAsActionPerformed

    private void mnSelectAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnSelectAllActionPerformed
        // TODO add your handling code here:
        txt.selectAll();
        
    }//GEN-LAST:event_mnSelectAllActionPerformed

    private void mnCutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCutActionPerformed
        // TODO add your handling code here:
        DefaultEditorKit.CutAction cutAction = new DefaultEditorKit.CutAction();
        cutAction.actionPerformed(null);
    }//GEN-LAST:event_mnCutActionPerformed

    private void mnPasteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnPasteActionPerformed
        // TODO add your handling code here:
        DefaultEditorKit.PasteAction pasteAction = new DefaultEditorKit.PasteAction();
        pasteAction.actionPerformed(null);
    }//GEN-LAST:event_mnPasteActionPerformed

    private void mnCopyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnCopyActionPerformed
        // TODO add your handling code here:
        DefaultEditorKit.CopyAction copyAction = new DefaultEditorKit.CopyAction();
        copyAction.actionPerformed(null);
    }//GEN-LAST:event_mnCopyActionPerformed

    private void mnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnUndoActionPerformed
        // TODO add your handling code here:
        try {
            if (undoManager.canUndo()) {
                undoManager.undo();
            }
        } catch (CannotUndoException e) {
        }
    }//GEN-LAST:event_mnUndoActionPerformed

    private void mnRedoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnRedoActionPerformed
        // TODO add your handling code here:
        try {
            if (undoManager.canRedo()) {
                undoManager.redo();
            }
        } catch (CannotRedoException e) {
        }
    }//GEN-LAST:event_mnRedoActionPerformed

    private void mnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnFindActionPerformed
        // TODO add your handling code here:
        FindDialog findDialog = new FindDialog(this, true);
        findDialog.setVisible(true);
    }//GEN-LAST:event_mnFindActionPerformed

    private void mnReplaceActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnReplaceActionPerformed
        // TODO add your handling code here:
        ReplaceDialog replaceDialog = new ReplaceDialog(this, true);
        replaceDialog.setVisible(true);
    }//GEN-LAST:event_mnReplaceActionPerformed

    private void mnChangeFontActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mnChangeFontActionPerformed
        // TODO add your handling code here:
          
        
    }//GEN-LAST:event_mnChangeFontActionPerformed
    public void saveFile(File f){
        PrintWriter w = null;
        
        try {
           w = new PrintWriter(f);
           w.print(txt.getText());
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            try {
                if (w != null) w.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
    }
    
    public void undoAndRedoSetup(){
        undoManager = new UndoManager();

        Document document = txt.getDocument();
        document.addUndoableEditListener(new UndoableEditListener() {
            @Override
            public void undoableEditHappened(UndoableEditEvent e) {
                undoManager.addEdit(e.getEdit());
            }
        });
        
    }
    public void readFile(File f) throws IOException{
        BufferedReader br = null;

        try {
            br = new BufferedReader(new FileReader(f));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        String s;
        String allText = "";
        while ((s = br.readLine()) != null){
            allText = allText + s + "\n";
        }
        if (allText.length() > 0){
            allText = allText.substring(0, allText.length() - 1);
        } 
        txt.setText(allText);
    }
    
    public boolean isTheSameWithCurrentFile(){
        BufferedReader br = null;
        
        try {
            br = new BufferedReader(new FileReader(currentFile));
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        }
        
        String s;
        String allText = "";
        try {
            while ((s = br.readLine()) != null){
                allText = allText + s + "\n";
            }
        } catch (IOException ex) {
            System.out.println(ex);
        }
        if (allText.length() > 0){
            allText = allText.substring(0, allText.length() - 1);
        } 
        if (allText.equals(txt.getText())){
            return true;
        }
        return false;
    }
    
    public void findNext(String findText, boolean isMatchCase){
        String sourceText;
        if (isMatchCase){
            sourceText = txt.getText();
        } else {
            sourceText = txt.getText().toLowerCase();
            findText = findText.toLowerCase();
        }
        
        String text;
        int currentSelectionStart = txt.getSelectionStart();
        int currentSelectionEnd = txt.getSelectionEnd();
        if (currentSelectionEnd == currentSelectionStart){
            text = sourceText;
            if (text.indexOf(findText) >= 0){
                txt.setSelectionStart(text.indexOf(findText));
                txt.setSelectionEnd(text.indexOf(findText) + findText.length());
            }
        } else {  
            text = sourceText.substring(currentSelectionEnd);
            if (text.indexOf(findText) >= 0){
                txt.setSelectionStart(currentSelectionEnd + text.indexOf(findText));
                txt.setSelectionEnd(currentSelectionEnd + text.indexOf(findText) + findText.length());
            }
         
        }
        if (txt.getText().equals("") || text.indexOf(findText) < 0){
            JOptionPane.showMessageDialog(null, "Can't find \n\"" + findText + "\"", "Notepad", JOptionPane.ERROR_MESSAGE);
            try {
                if(isMatchCase){
                    if (!txt.getSelectedText().equals(findText)){
                        txt.setSelectionEnd(currentSelectionStart);
                    }
                } else {
                    if (!txt.getSelectedText().toLowerCase().equals(findText)){
                        txt.setSelectionEnd(currentSelectionStart);
                    }
                }
            } catch (Exception e) {
                System.out.println("No selected");
            }  
        }
    }
    
    
    public void findPrevious(String findText, boolean isMatchCase){
        String sourceText;
        if (isMatchCase){
            sourceText = txt.getText();
        } else {
            sourceText = txt.getText().toLowerCase();
            findText = findText.toLowerCase();
        }
        
        String text;
        int currentSelectionStart = txt.getSelectionStart();
        int currentSelectionEnd = txt.getSelectionEnd();
        if (currentSelectionEnd == currentSelectionStart){
            text = sourceText;
            if (text.lastIndexOf(findText) >= 0){
                txt.setSelectionStart(text.indexOf(findText));
                txt.setSelectionEnd(text.indexOf(findText) + findText.length());
            }
        } else {  
            text = sourceText.substring(0, currentSelectionStart);
            if (text.lastIndexOf(findText) >= 0){
                
                txt.setSelectionStart(text.lastIndexOf(findText));
                txt.setSelectionEnd(text.lastIndexOf(findText) + findText.length());
            }
        }
        if (txt.getText().equals("") || text.lastIndexOf(findText) < 0){
            JOptionPane.showMessageDialog(null, "Can't find \n\"" + findText + "\"", "Notepad", JOptionPane.ERROR_MESSAGE);
            try {
                if(isMatchCase){
                    if (!txt.getSelectedText().equals(findText)){
                        txt.setSelectionEnd(currentSelectionStart);
                    }
                } else {
                    if (!txt.getSelectedText().toLowerCase().equals(findText)){
                        txt.setSelectionEnd(currentSelectionStart);
                    }
                }
            } catch (Exception e) {
                System.out.println("No selected");
            }  
        }
    }
    
    public void replaceText(String findText, String replaceText, boolean isMatchCase){
        //prepare
        
        String sourceText;
        if (isMatchCase){
            sourceText = txt.getText();
        } else {
            sourceText = txt.getText().toLowerCase();
            findText = findText.toLowerCase();
        }
        
        String text;
        int currentSelectionStart = txt.getSelectionStart();
        int currentSelectionEnd = txt.getSelectionEnd();
        
        //count find text
        int countFindText = 0;      
        Boolean isMore = true;
        String tempString = sourceText;
        while (isMore){
            int index = tempString.indexOf(findText);
            if ( index >= 0){
                countFindText++;
                tempString = tempString.substring(index + findText.length());
            } else {
                isMore = false;
            }
        }
        if (countFindText == 0) {
            JOptionPane.showMessageDialog(null, "Can't find \n\"" + findText + "\"", "Notepad", JOptionPane.ERROR_MESSAGE);
        }
        
        //if nothing is selected then find text and select it first
        //else check the selected is the same as find text
        //      if same then replace and cut source text then select the next text if it available
        //          if cant find the next text in the end of source text then reget source text again
        if (currentSelectionStart == currentSelectionEnd){
           text = sourceText;
           if (text.lastIndexOf(findText) >= 0){
                txt.setSelectionStart(text.indexOf(findText));
                txt.setSelectionEnd(text.indexOf(findText) + findText.length());
            }
        } else {
            try {
                if(isMatchCase){
                    if (!txt.getSelectedText().equals(findText)){
                        txt.setSelectionEnd(currentSelectionStart);
                    } else {
                        txt.replaceSelection(replaceText);
                        currentSelectionEnd = currentSelectionEnd + (replaceText.length() - findText.length());
                    }
                } else {
                    if (!txt.getSelectedText().toLowerCase().equals(findText)){
                        txt.setSelectionEnd(currentSelectionStart);
                    } else {
                        txt.replaceSelection(replaceText);
                        System.out.println(currentSelectionEnd);
                        currentSelectionEnd = currentSelectionEnd + (replaceText.length() - findText.length());
                        System.out.println(currentSelectionEnd);
                    }
                }                
            } catch (Exception e){
                e.printStackTrace();
            }
            
            //update source text 
            if (isMatchCase){
                sourceText = txt.getText();
            } else {
                sourceText = txt.getText().toLowerCase();
            }
            // continue cut source text and find text
            text = sourceText.substring(currentSelectionEnd);
            System.out.println(text);
            if (text.indexOf(findText) >= 0){
                txt.setSelectionStart(currentSelectionEnd + text.indexOf(findText));
                txt.setSelectionEnd(currentSelectionEnd + text.indexOf(findText) + findText.length());
            } else {
                
            }
        }        
    }
    
    public void replaceAllText(String findText, String replaceText, boolean isMatchCase){
        //prepare
        String sourceText;
        if (isMatchCase){
            sourceText = txt.getText();
        } else {
            sourceText = txt.getText().toLowerCase();
            findText = findText.toLowerCase();
        }
        int currentSelectionStart = txt.getSelectionStart();
        int currentSelectionEnd = txt.getSelectionEnd();
        
       
        //count find text
        int countFindText = 0;
        Boolean isMore = true;
        String tempString = sourceText;
        
        while (isMore && !findText.trim().isEmpty()){
            int index = tempString.indexOf(findText);
            if ( index >= 0){
                countFindText++;
                tempString = tempString.substring(index + findText.length());
            } else {
                isMore = false;
            }
        }
        txt.setSelectionEnd(currentSelectionStart);
        if (countFindText == 0) {
            JOptionPane.showMessageDialog(null, "Can't find \n\"" + findText + "\"", "Notepad", JOptionPane.ERROR_MESSAGE);
            
        }
        for (int i = 0; i <= countFindText; i++){
            replaceText(findText, replaceText, isMatchCase);
        }
       
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TextPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TextPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TextPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TextPanel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                TextPanel textPanel = new TextPanel();
                textPanel.setVisible(true);
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JMenuItem mnChangeFont;
    private javax.swing.JMenuItem mnCopy;
    private javax.swing.JMenuItem mnCut;
    private javax.swing.JMenuItem mnExit;
    private javax.swing.JMenu mnFile;
    private javax.swing.JMenuItem mnFind;
    private javax.swing.JMenuItem mnNew;
    private javax.swing.JMenuItem mnNew2;
    private javax.swing.JMenuItem mnOpen;
    private javax.swing.JMenuItem mnPaste;
    private javax.swing.JMenuItem mnRedo;
    private javax.swing.JMenuItem mnReplace;
    private javax.swing.JMenuItem mnSave;
    private javax.swing.JMenuItem mnSaveAs;
    private javax.swing.JMenuItem mnSelectAll;
    private javax.swing.JMenuItem mnUndo;
    private javax.swing.JTextArea txt;
    // End of variables declaration//GEN-END:variables
}