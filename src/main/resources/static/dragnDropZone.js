const items = document.querySelectorAll('.drag-item');
const dropZone = document.getElementById('drop-zone');

items.forEach(item => {
    item.addEventListener('click', () => {
        const itemId = item.id;

        // Check if the item is already in the drop zone
        const existingItem = document.getElementById(`added-${itemId}`);
        if (!existingItem) {
            // Create a new element to show in the drop zone
            const addedItem = document.createElement('div');
            addedItem.classList.add('added-item');
            addedItem.id = `added-${itemId}`;
            addedItem.textContent = item.textContent;

            // Create and append a remove button
            const removeBtn = document.createElement('span');
            removeBtn.classList.add('remove-btn');
            removeBtn.textContent = 'x';
            addedItem.appendChild(removeBtn);

            // Append the added item to the drop zone
            dropZone.appendChild(addedItem);

            // Add event listener for the remove button
            removeBtn.addEventListener('click', () => {
                dropZone.removeChild(addedItem);
            });
        }
    });
});