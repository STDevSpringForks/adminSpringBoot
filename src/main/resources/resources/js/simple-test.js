document.addEventListener('DOMContentLoaded', () => {
    // Common javascript initialization can go here
});

/**
 * Move Cursor To end of the input.
 * @param input
 */
function moveCursorToEnd(input) {
    const element = (typeof input === 'string') ? document.querySelector(input) : input;
    const originalValue = element.value;
    element.value = '';
    element.blur();
    element.focus();
    element.value = originalValue;
}
