// Function to paste clipboard content into the textbox
async function pasteClipboard() {
    try {
        document.getElementById('urlTextbox').value =
            await navigator.clipboard.readText();
    } catch (err) {
        alert("Failed to read clipboard content: " + err);
    }
}