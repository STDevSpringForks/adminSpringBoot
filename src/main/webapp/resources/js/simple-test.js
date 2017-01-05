$(function(){
	
	/**
	 * Example: Home > View Tiwilio SMS
	 */
	$('#btitle').html($('title').html());
	
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
