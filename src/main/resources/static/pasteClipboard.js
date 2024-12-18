// Function to paste clipboard content into the textbox
async function pasteClipboard() {
    try {
        const urlTextBoxElement = document.getElementById('urlTextbox');
        urlTextBoxElement.focus();
        urlTextBoxElement.value = await navigator.clipboard.readText();
    } catch (err) {
        alert("Failed to read clipboard content: " + err);
    }
}