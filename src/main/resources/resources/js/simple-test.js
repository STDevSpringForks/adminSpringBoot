$(function(){
        // Common javascript initialization can go here
});

/**
 * Move Cursor To end of the input.
 * @param input
 */
function moveCursorToEnd(input) {
    var originalValue = input.val();
    input.val('');
    input.blur().focus().val(originalValue);
}
