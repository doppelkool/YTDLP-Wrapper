const items = document.querySelectorAll('.drag-item');
const dropZone = document.getElementById('drop-zone');

items.forEach(item => {
    item.addEventListener('click', () => {
        const itemId = item.id;

        // Check if the item is already in the drop zone
        if (document.getElementById(`added-${itemId}`)) {
            return;
        }

        const addedItem = document.createElement('div');
        addedItem.classList.add('added-item');
        addedItem.id = `added-${itemId}`;
        addedItem.textContent = item.textContent;
        const removeBtn = document.createElement('span');
        removeBtn.classList.add('remove-btn');
        removeBtn.textContent = 'x';
        addedItem.appendChild(removeBtn);
        dropZone.appendChild(addedItem);
        removeBtn.addEventListener('click', () => {
            dropZone.removeChild(addedItem);
        });
    });
});