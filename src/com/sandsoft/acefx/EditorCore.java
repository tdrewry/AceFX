/*
 * Copyright 2015 Sudipto Chandra.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.sandsoft.acefx;

import javafx.scene.web.WebEngine;

/**
 *
 * @author Sudipto Chandra.
 */
public class EditorCore {

    //<editor-fold defaultstate="collapsed" desc="Editor Core Methods and Objecets">
    /**
     * web engine
     */
    private WebEngine webEngine;

    /**
     * Constructor.
     *
     * @param engine WebEngine to pass javascript commands.
     */
    public EditorCore(WebEngine engine) {
        webEngine = engine;
    }

    /**
     * Checks if the editor is ready for interaction.
     *
     * @return True if worker is successfully loaded.
     */
    public boolean isReady() {
        return (webEngine != null
                && webEngine.getLoadWorker().getState()
                == javafx.concurrent.Worker.State.SUCCEEDED);
    }

    /**
     * Executes a java-script and returns result.
     *
     * @param script Script to execute.
     * @return Result return by the function.
     */
    protected final Object execute(String script) {
        if (isReady()) {
            return (Object) webEngine.executeScript(script);
        }
        return null;
    }

    /**
     * formats a content into a string passable inside quote.
     *
     * @param content text to format
     * @return formated content
     */
    private static String formatText(String content) {
        return content
                .replace("\\", "\\\\") //replace backslash
                .replace("\"", "\\\"") //replace quote
                .replace("\r", "") //replace return
                .replace("\n", "\\n") //replace new line
                .replace("\t", "\\t") //replace tab
                ;
    }

    /**
     * Formats the boolean value and return JavaScript string.
     *
     * @param val Value to convert.
     * @return JavaScript supported string.
     */
    private static String formatBool(boolean val) {
        return val ? "true" : "false";
    }

    /**
     * Formats other value and return JavaScript string.
     *
     * @param num int to convert.
     * @return JavaScript supported string.
     */
    private static String formatOther(int num) {
        return String.valueOf(num);
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Editor Functions Definitions">
    /**
     * Aligns the cursors or selected text.
     */
    public void alignCursors() {
        execute("editor.alignCursors();");
    }

    /**
     * Out-dents the current line.
     */
    public void blockOutdent() {
        execute("editor.alignCursors();");
    }

    /**
     * Blurs the current textInput.
     */
    public void blur() {
        execute("editor.blur();");
    }

    /**
     * Attempts to center the current selection on the screen.
     */
    public void centerSelection() {
        execute("editor.centerSelection();");
    }

    /**
     * Empties the selection (by de-selecting it). This function also emits the
     * 'changeSelection' event.
     */
    public void clearSelection() {
        execute("editor.clearSelection();");
    }

    /**
     * Copies all the selected lines down one row.
     *
     * @return
     */
    public int copyLinesDown() {
        return (int) execute("editor.copyLinesDown();");
    }

    /**
     * Copies all the selected lines up one row.
     *
     * @return
     */
    public int copyLinesUp() {
        return (int) execute("editor.copyLinesUp();");
    }

    /**
     * Duplicate the selected text.
     */
    public void duplicateSelection() {
        execute("editor.duplicateSelection();");
    }

    /**
     * Removes all the selections except the last added one.
     */
    public void exitMultiSelectMode() {
        execute("editor.exitMultiSelectMode();");
    }

    /**
     * Brings the current textInput into focus.
     */
    public void focus() {
        execute("editor.focus();");
    }

    /**
     * Returns true if the behaviors are currently enabled. "Behaviors" in this
     * case is the auto-pairing of special characters, like quotation marks,
     * parenthesis, or brackets.
     *
     * @return
     */
    public boolean getBehavioursEnabled() {
        return (boolean) execute("editor.getBehavioursEnabled();");
    }

    /**
     * Returns the string of text currently highlighted.
     *
     * @return
     */
    public String getCopyText() {
        return (String) execute("editor.getCopyText();");
    }

    /**
     * Returns the index of the first visible row.
     *
     * @return
     */
    public int getFirstVisibleRow() {
        return (int) execute("editor.getFirstVisibleRow();");
    }

    /**
     * Returns true if current lines are always highlighted.
     *
     * @return
     */
    public boolean getHighlightActiveLine() {
        return (boolean) execute("editor.getHighlightActiveLine();");
    }

    /**
     * Returns true if currently highlighted words are to be highlighted.
     *
     * @return
     */
    public boolean getHighlightSelectedWord() {
        return (boolean) execute("editor.getHighlightSelectedWord();");
    }

    /**
     * Returns the keyboard handler, such as "vim" or "windows".
     *
     * @return
     */
    public String getKeyboardHandler() {
        return (String) execute("editor.getKeyboardHandler();");
    }

    /**
     * Returns the index of the last visible row.
     *
     * @return
     */
    public int getLastVisibleRow() {
        return (int) execute("editor.getLastVisibleRow();");
    }

    /**
     * Returns true if overwrites are enabled; false otherwise.
     *
     * @return
     */
    public boolean getOverwrite() {
        return (boolean) execute("editor.getOverwrite();");
    }

    /**
     * Returns the column number of where the print margin is.
     *
     * @return
     */
    public int getPrintMarginColumn() {
        return (int) execute("editor.getPrintMarginColumn();");
    }

    /**
     * Returns true if the editor is set to read-only mode.
     *
     * @return
     */
    public boolean getReadOnly() {
        return (boolean) execute("editor.getReadOnly();");
    }

    /**
     * Returns the value indicating how fast the mouse scroll speed is (in
     * milliseconds).
     *
     * @return
     */
    public int getScrollSpeed() {
        return (int) execute("editor.getScrollSpeed();");
    }

    /**
     * Returns the currently highlighted selection.
     *
     * @return
     */
    public String getSelection() {
        return (String) execute("editor.getSelection();");
    }

    //Returns the Range for the selected text.
    //public Range getSelectionRange()  { }
    /**
     * Returns the current selection style.
     *
     * @return
     */
    public String getSelectionStyle() {
        return (String) execute("editor.getSelectionStyle();");
    }

    //Returns the current session being used.
    //public EditSession getSession()  { }
    /**
     * Returns true if the fold widgets are shown.
     *
     * @return
     */
    public boolean getShowFoldWidgets() {
        return (boolean) execute("editor.getShowFoldWidgets();");
    }

    /**
     * Returns true if invisible characters are being shown.
     *
     * @return
     */
    public boolean getShowInvisibles() {
        return (boolean) execute("editor.getShowInvisibles();");
    }

    /**
     * Returns true if the print margin is being shown.
     *
     * @return
     */
    public boolean getShowPrintMargin() {
        return (boolean) execute("editor.getShowPrintMargin();");
    }

    /**
     * Return the current text in the editor.
     *
     * @return Current content in the editor.
     */
    public String getText() {
        return getValue();
    }

    /**
     * Returns the path of the current theme.
     *
     * @return
     */
    public String getTheme() {
        return (String) execute("editor.getTheme();");
    }

    /**
     * Returns the current session's content.
     *
     * @return
     */
    public String getValue() {
        return (String) execute("editor.getValue();");
    }

    /**
     * Returns true if the wrapping behaviors are currently enabled.
     *
     * @return
     */
    public boolean getWrapBehavioursEnabled() {
        return (boolean) execute("editor.getWrapBehavioursEnabled();");
    }

    /**
     * Moves the cursor to the specified line number, and also into the
     * indicated column.
     *
     * @param lineint Required. The line number to go to
     * @param column Required. A column number to go to
     * @param animate Required. If true animates scrolling
     */
    public void gotoLine(int lineNumber, int column, boolean animate) {
        execute("editor.gotoLine(" + formatOther(lineNumber) + ","
                + formatOther(column) + "," + formatBool(animate) + ");");
    }

    /**
     * Shifts the document to wherever "page down" is, as well as moving the
     * cursor position.
     */
    public void gotoPageDown() {
        execute("editor.gotoPageDown();");
    }

    /**
     * Shifts the document to wherever "page up" is, as well as moving the
     * cursor position.
     */
    public void gotoPageUp() {
        execute("editor.gotoPageUp();");
    }

    /**
     * Indents the current line.
     */
    public void indent() {
        execute("editor.indent();");
    }

    /**
     * Inserts text into wherever the cursor is pointing.
     *
     * @param text Required. The new text to add.
     */
    public void insert(String text) {
        execute("editor.insert(\"" + formatText(text) + "\");");
    }

    /**
     * Returns true if the current textInput is in focus.
     *
     * @return true if the current textInput is in focus.
     */
    public boolean isFocused() {
        return (boolean) execute("editor.isFocused();");
    }

    /**
     * Indicates if the entire row is currently visible on the screen.
     *
     * @param row Required. The row to check
     * @return true if the entire row is currently visible on the screen.
     */
    public boolean isRowFullyVisible(int row) {
        return (boolean) execute("editor.isRowFullyVisible(" + formatOther(row) + ");");
    }

    /**
     * Indicates if the row is currently visible on the screen.
     *
     * @param row Required. The row to check
     * @return true if the row is currently visible on the screen.
     */
    public boolean isRowVisible(int row) {
        return (boolean) execute("editor.isRowVisible(" + formatOther(row) + ");");
    }

    /**
     * If the character before the cursor is a number, this functions changes
     * its value by amount.
     *
     * @param amount
     */
    public void modifyNumber(int amount) {
        execute("editor.modifyNumber(" + formatOther(amount) + ");");
    }

    /**
     * Moves the cursor to the specified row and column. Note that this does not
     * de-select the current selection.
     *
     * @param row Required. The row to move.
     * @param column Required. The columns to move.
     */
    public void moveCursorTo(int row, int column) {
        execute("editor.moveCursorTo(" + formatOther(row) + "," + formatOther(column) + ");");
    }

    /**
     * Moves the cursor to the position indicated by pos.row and pos.column.
     *
     * @param row Required. The row to move.
     * @param column Required. The columns to move.
     */
    public void moveCursorToPosition(int row, int column) {
        execute("editor.moveCursorToPosition({"
                + "row : " + formatOther((int) row)
                + ", column:" + formatOther((int) column)
                + "});");
    }

    /**
     * Shifts all the selected lines down one row.
     *
     * @return number of lines moved.
     */
    public int moveLinesDown() {
        return (int) execute("editor.moveLinesDown();");
    }

    /**
     * Shifts all the selected lines up one row.
     *
     * @return number of lines moved.
     */
    public int moveLinesUp() {
        return (int) execute("editor.moveLinesUp();");
    }

    /**
     * Undocumented.
     */
    public void moveText() {
        execute("editor.moveText();");
    }

    /**
     * Moves the cursor down in the document the specified number of times. Note
     * that this does de-select the current selection.
     *
     * @param times Required. The number of times to change navigation
     */
    public void navigateDown(int times) {
        execute("editor.navigateDown(" + formatOther(times) + ");");
    }

    /**
     * Moves the cursor to the end of the current file. Note that this does
     * de-select the current selection.
     */
    public void navigateFileEnd() {
        execute("editor.navigateFileEnd();");
    }

    /**
     * Moves the cursor to the end of the current file. Note that this does
     * de-select the current selection.
     */
    public void navigateFileStart() {
        execute("editor.navigateFileStart();");
    }

    /**
     * Moves the cursor left in the document the specified number of times. Note
     * that this does de-select the current selection.
     *
     * @param times Required. The number of times to change navigation
     */
    public void navigateLeft(int times) {
        execute("editor.navigateLeft(" + formatOther(times) + ");");
    }

    /**
     * Moves the cursor to the end of the current line. Note that this does
     * de-select the current selection.
     */
    public void navigateLineEnd() {
        execute("editor.navigateLineEnd();");
    }

    /**
     * Moves the cursor to the start of the current line. Note that this does
     * de-select the current selection.
     */
    public void navigateLineStart() {
        execute("editor.navigateLineStart();");
    }

    /**
     * Moves the cursor right in the document the specified number of times.
     * Note that this does de-select the current selection.
     *
     * @param times Required. The number of times to change navigation
     */
    public void navigateRight(int times) {
        execute("editor.navigateRight(" + formatOther(times) + ");");
    }

    /**
     * Moves the cursor to the specified row and column. Note that this does
     * de-select the current selection.
     *
     * @param row Required. The row to move.
     * @param column Required. The columns to move.
     */
    public void navigateTo(int row, int column) {
        execute("editor.navigateTo(" + formatOther(row) + "," + formatOther(column) + ");");
    }

    /**
     * Moves the cursor up in the document the specified number of times. Note
     * that this does de-select the current selection.
     *
     * @param times
     */
    public void navigateUp(int times) {
        execute("editor.navigateUp(" + formatOther(times) + ");");
    }

    /**
     * Moves the cursor to the word immediately to the left of the current
     * position. Note that this does de-select the current selection.
     */
    public void navigateWordLeft() {
        execute("editor.navigateWordLeft();");
    }

    /**
     * Moves the cursor to the word immediately to the right of the current
     * position. Note that this does de-select the current selection.
     */
    public void navigateWordRight() {
        execute("editor.navigateWordRight();");
    }

    /**
     * Perform a redo operation on the document, re-implementing the last
     * change.
     */
    public void redo() {
        execute("editor.redo();");
    }

    /**
     * Removes words of text from the editor. A "word" is defined as a string of
     * characters book-ended by whitespace.
     *
     * @param dir Required. The direction of the deletion to occur, either
     * "left" or "right"
     */
    public void remove(String dir) {
        execute("editor.remove(\"" + formatText(dir) + "\");");
    }

    /**
     * Removes all the lines in the current selection
     */
    public void removeLines() {
        execute("editor.removeLines();");
    }

    /**
     * Removes all the words to the right of the current selection , until the
     * end of the line.
     */
    public void removeToLineEnd() {
        execute("editor.removeToLineEnd();");
    }

    /**
     * Removes all the words to the left of the current selection , until the
     * start of the line.
     */
    public void removeToLineStart() {
        execute("editor.removeToLineStart();");
    }

    /**
     * Removes the word directly to the left of the current selection.
     */
    public void removeWordLeft() {
        execute("editor.removeWordLeft();");
    }

    /**
     * Removes the word directly to the right of the current selection.
     */
    public void removeWordRight() {
        execute("editor.removeWordRight();");
    }

    /**
     * Triggers a resize of the editor.
     *
     * @param force Required. If true, recomputes the size, even if the height
     * and width haven't changed
     *
     */
    public void resize(boolean force) {
        execute("editor.resize(" + formatBool(force) + ");");
    }

    /**
     * <strong>Undocumented</strong>
     */
    public void revealRange() {
        execute("editor.revealRange();");
    }

    /**
     * Scrolls the document to wherever "page down" is , without changing the
     * cursor position.
     */
    public void scrollPageDown() {
        execute("editor.scrollPageDown();");
    }

    /**
     * Scrolls the document to wherever "page up" is , without changing the
     * cursor position.
     */
    public void scrollPageUp() {
        execute("editor.scrollPageUp();");
    }

    /**
     * Moves the editor to the specified row.
     *
     * @param row Required. Row number.
     */
    public void scrollToRow(int row) {
        execute("editor.resize(" + formatOther(row) + ");");
    }

    /**
     * Selects all the text in editor.
     */
    public void selectAll() {
        execute("editor.selectAll();");
    }

    /**
     * Selects the text from the current position of the document until where a
     * "page down" finishes.
     */
    public void selectPageDown() {
        execute("editor.selectPageDown();");
    }

    /**
     * Selects the text from the current position of the document until where a
     * "page up" finishes.
     */
    public void selectPageUp() {
        execute("editor.selectPageUp();");
    }

    /**
     * Specifies whether to use behaviors or not. "Behaviors" in this case is
     * the auto-pairing of special characters, like quotation marks,
     * parenthesis, or brackets.
     *
     * @param enabled Required. Enables or disables behaviors
     */
    public void setBehavioursEnabled(boolean enabled) {
        execute("editor.setBehavioursEnabled(" + formatBool(enabled) + ");");
    }

    /**
     * Sets the delay(in milliseconds) of the mouse drag.
     *
     * @param dragDelay Required. A value indicating the new delay
     */
    public void setDragDelay(int dragDelay) {
        execute("editor.setDragDelay(" + formatOther(dragDelay) + ");");
    }

    /**
     * Set a new font size(in pixels) for the editor text.
     *
     * @param size
     */
    public void setFontSize(int size) {
        execute("editor.setFontSize(" + formatOther(size) + ");");
    }

    /**
     * Determines whether or not the current line should be highlighted.
     *
     * @param shouldHighlight Required. Set to true to highlight the current
     * line
     */
    public void setHighlightActiveLine(boolean shouldHighlight) {
        execute("editor.setHighlightActiveLine(" + formatBool(shouldHighlight) + ");");
    }

    /**
     * etermines whether or not the current gutter line should be highlighted.
     *
     * @param shouldHighlight Required. Set to true to highlight the current
     * line
     */
    public void setHighlightGutterLine(boolean shouldHighlight) {
        execute("editor.setHighlightGutterLine(" + formatBool(shouldHighlight) + ");");
    }

    /**
     * Determines if the currently selected word should be highlighted.
     *
     * @param shouldHighlight Required. Set to true to highlight the current
     * line
     */
    public void setHighlightSelectedWord(boolean shouldHighlight) {
        execute("editor.setHighlightSelectedWord(" + formatBool(shouldHighlight) + ");");
    }

    /**
     * Sets a new key handler, such as "vim" or "windows".
     *
     * @param keyboardHandler Required. The new key handler
     */
    public void setKeyboardHandler(String keyboardHandler) {
        execute("editor.setKeyboardHandler(\"" + formatText(keyboardHandler) + "\");");
    }

    /**
     * Pass in true to enable overwrites in your session, or false to disable.
     * If overwrites is enabled, any text you enter will type over any text
     * after it. If the value of overwrite changes, this function also emits the
     * changeOverwrite event.
     *
     * @param overwrite Required. Defines whether or not to set overwrites
     */
    public void setOverwrite(boolean overwrite) {
        execute("editor.setOverwrite(" + formatBool(overwrite) + ");");
    }

    /**
     * Sets the column defining where the print margin should be.
     *
     * @param showPrintMargin Required. Specifies the new print margin.
     */
    public void setPrintMarginColumn(int showPrintMargin) {
        execute("editor.setPrintMarginColumn(" + formatOther(showPrintMargin) + ");");
    }

    /**
     * If readOnly is true, then the editor is set to read-only mode, and none
     * of the content can change.
     *
     * @param readOnly Required. Specifies whether the editor can be modified or
     * not
     */
    public void setReadOnly(boolean readOnly) {
        execute("editor.setReadOnly(" + formatBool(readOnly) + ");");
    }

    /**
     * Sets how fast the mouse scrolling should do.
     *
     * @param speed Required. A value indicating the new speed (in milliseconds)
     */
    public void setScrollSpeed(int speed) {
        execute("editor.setScrollSpeed(" + formatOther(speed) + ");");
    }

    /**
     * Indicates how selections should occur. <br/>
     * By default, selections are set to "line". There are no other styles at
     * the moment, although this code change in the future. <br/>
     * This function also emits the 'changeSelectionStyle' event.
     *
     * @param style Required. The new selection style
     */
    public void setSelectionStyle(String style) {
        execute("editor.setSelectionStyle(\"" + formatText(style) + "\");");
    }

    /**
     * Indicates whether the fold widgets are shown or not.
     *
     * @param show Required. Specifies whether the fold widgets are shown.
     */
    public void setShowFoldWidgets(boolean show) {
        execute("editor.setShowFoldWidgets(" + formatBool(show) + ");");
    }

    /**
     * If showInvisibles is set to true, invisible characters—like spaces or new
     * lines—are show in the editor.
     *
     * @param showInvisibles
     */
    public void setShowInvisibles(boolean showInvisibles) {
        execute("editor.setShowInvisibles(" + formatBool(showInvisibles) + ");");
    }

    /**
     * If showPrintMargin is set to true, the print margin is shown in the
     * editor .
     *
     * @param showPrintMargin Required. Specifies whether or not to show
     * invisible characters.
     */
    public void setShowPrintMargin(boolean showPrintMargin) {
        execute("editor.setShowPrintMargin(" + formatBool(showPrintMargin) + ");");
    }

    /**
     * Sets the document display text.
     *
     * @param text The new text to set for the document.
     */
    public void setValue(String text) {
        setValue(text, -1);
    }

    /**
     * Sets a new theme for the editor. theme should exist , and be a directory
     * path, like ace/theme/textmate.
     *
     * @param theme Required. The path to a theme.
     */
    public void setTheme(String theme) {
        execute("editor.setTheme(\"" + theme + "\");");
    }

    /**
     * Sets the current document to val.
     *
     * @param val Required. The new value to set for the document.
     * @param cursorPos Required. Where to set the new value. undefined or 0 is
     * selectAll, -1 is at the document start, and 1 is at the end
     * @return
     */
    public String setValue(String val, int cursorPos) {
        return (String) execute("editor.setValue(\"" + formatText(val) + "\"," + formatOther(cursorPos) + ");");
    }

    /**
     * Specifies whether to use wrapping behaviors or not, i.e.automatically
     * wrapping the selection with characters such as brackets when such a
     * character is typed in.
     *
     * @param enabled
     */
    public void setWrapBehavioursEnabled(boolean enabled) {
        execute("editor.setWrapBehavioursEnabled(" + formatBool(enabled) + ");");
    }

    /**
     * <strong>Undocumented</strong>
     */
    public void sortLines() {
        execute("editor.sortLines();");
    }

    /**
     * Given the currently selected range ,this function either comments all the
     * lines, or uncomments all of them.
     */
    public void toggleCommentLines() {
        execute("editor.toggleCommentLines();");
    }

    /**
     * Sets the value of overwrite to the opposite of whatever it currently is.
     */
    public void toggleOverwrite() {
        execute("editor.toggleOverwrite();");
    }

    /**
     * Converts the current selection entirely into lowercase.
     */
    public void toLowerCase() {
        execute("editor.toLowerCase();");
    }

    /**
     * Converts the current selection entirely into uppercase.
     */
    public void toUpperCase() {
        execute("editor.toUpperCase();");
    }

    /**
     * Transposes current line.
     */
    public void transposeLetters() {
        execute("editor.transposeLetters();");
    }

    /**
     * Transposes the selected ranges.
     *
     * @param dir Required. The direction to rotate selections.
     */
    public void transposeSelections(int dir) {
        execute("editor.setWrapBehavioursEnabled(" + formatOther(dir) + ");");
    }

    /**
     * Perform an undo operation on the document , reverting the last change.
     */
    public void undo() {
        execute("editor.undo();");
    }

    /**
     * Updates the cursor and marker layers. public void
     */
    public void updateSelectionMarkers() {
        execute("editor.updateSelectionMarkers();");
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Editor -> Editor Session Methods ">
    /**
     * Clears all the annotations for this session. This function also triggers
     * the 'changeAnnotation' event.
     */
    public void clearAnnotations() {
        execute("editor.getSession().clearAnnotations()");
    }

    /**
     * Removes a breakpoint on the row number given by rows. This function also
     * emites the 'changeBreakpoint' event.
     */
    public void clearBreakpoint(int row) {
        execute("editor.getSession().clearBreakpoint(" + formatOther(row) + ")");
    }

    /**
     * Duplicates all the text between firstRow and lastRow.
     */
    public int duplicateLines(int firstRow, int lastRow) {
        return (int) execute("editor.getSession().duplicateLines("
                + formatOther(firstRow) + "," + formatOther(lastRow) + ")");
    }

    /**
     * Returns a verbatim copy of the given line as it is in the document
     */
    public String getLine(int row) {
        return (String) execute("editor.getSession().getLine(" + formatOther(row) + ")");
    }

    /**
     * Returns number of screenrows in a wrapped line.
     */
    public int getRowLength(int row) {
        return (int) execute("editor.getSession().getRowLength(" + formatOther(row) + ")");
    }

    /**
     * Returns the current tab size.
     */
    public int getTabSize() {
        return (int) execute("editor.getSession().getTabSize()");
    }

    /**
     * Returns the current value for tabs. If the user is using soft tabs, this
     * will be a series of spaces (defined by getTabSize()); otherwise it's
     * simply '\t'.
     */
    public String getTabString() {
        return (String) execute("editor.getSession().getTabString()");
    }

    /**
     * Returns true if soft tabs are being used, false otherwise.
     */
    public boolean getUseSoftTabs() {
        return (boolean) execute("editor.getSession().getUseSoftTabs()");
    }

    /**
     * Returns true if wrap mode is being used; false otherwise.
     */
    public boolean getUseWrapMode() {
        return (boolean) execute("editor.getSession().getUseWrapMode()");
    }

    /**
     * Indents all the rows, from startRow to endRow (inclusive), by prefixing
     * each row with the token in indentString.
     */
    public void indentRows(int startRow, int endRow, String indentString) {
        execute("editor.getSession().indentRows("
                + formatOther(startRow) + "," + formatOther(endRow)
                + ",\"" + formatText(indentString) + "\")");

    }

    /**
     * Inserts a block of text and the indicated position.
     */
    public void insert(int row, int column, String text) {
        execute("editor.getSession().insert("
                + "{ row:" + formatOther(row)
                + ", column:" + formatOther(column)
                + ",\"" + formatText(text) + "\")");
    }

    public void reset() {
        execute("editor.getSession().highlight()");
    }

    public void resetCaches() {
        execute("editor.getSession().resetCaches()");
    }

    /**
     * Sets a breakpoint on the row number given by rows. This function also
     * emites the 'changeBreakpoint' event.
     */
    public void setBreakpoint(int row, String className) {
        execute("editor.getSession().setBreakpoint("
                + formatOther(row) + ",\"" + formatText(className) + "\");");
    }

    /**
     * Set the number of spaces that define a soft tab; for example, passing in
     * 4 transforms the soft tabs to be equivalent to four spaces. This function
     * also emits the changeTabSize event.
     */
    public void setTabSize(int tabSize) {
        execute("editor.getSession().setTabSize(" + formatOther(tabSize) + ")");
    }

    /**
     * Enables or disables highlighting of the range where an undo occurred.
     */
    public void setUndoSelect(boolean enable) {
        execute("editor.getSession().setUndoSelect(" + formatBool(enable) + ")");
    }

    /**
     * Pass true to enable the use of soft tabs. Soft tabs means you're using
     * spaces instead of the tab character ('\t').
     */
    public void setUseSoftTabs(boolean useSoftTabs) {
        execute("editor.getSession().setUseSoftTabs(" + formatBool(useSoftTabs) + ")");
    }

    /**
     * Sets whether or not line wrapping is enabled. If useWrapMode is different
     * than the current value, the 'changeWrapMode' event is emitted.
     */
    public void setUseWrapMode(boolean useWrapMode) {
        execute("editor.getSession().setUseWrapMode(" + formatBool(useWrapMode) + ")");
    }

    /**
     * Sets the boundaries of wrap. Either value can be null to have an
     * unconstrained wrap, or, they can be the same number to pin the limit. If
     * the wrap limits for min or max are different, this method also emits the
     * 'changeWrapMode' event.
     */
    public void setWrapLimitRange(int min, int max) {
        execute("editor.getSession().setWrapLimitRange("
                + formatOther(min) + "," + formatOther(max) + ")");
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Editor -> Editor Session -> Undo Manager methods">
    /**
     * Returns true if there are redo operations left to perform.
     *
     * @return true if there are redo operations left to perform.
     */
    public boolean hasRedo() {
        return (boolean) execute("editor.getSession().getUndoManager().hasRedo()");
    }

    /**
     * Returns true if there are undo operations left to perform.
     *
     * @return true if there are undo operations left to perform.
     */
    public boolean hasUndo() {
        return (boolean) execute("editor.getSession().getUndoManager().hasUndo()");
    }

    /**
     * Destroys the stack of undo and redo redo operations.
     */
    public void resetUndoManager() {
        execute("editor.getSession().getUndoManager().reset()");
    }
//</editor-fold>
}
