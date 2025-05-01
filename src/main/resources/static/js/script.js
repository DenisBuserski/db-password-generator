function copyPassword() {
    const passwordText = document.getElementById("generatedPassword");
    const text = passwordText.innerText;

    navigator.clipboard.writeText(text).then(() => {
        const message = document.getElementById("copyMessage");
        message.style.display = "block";  // Show the "Copied!" message
        setTimeout(() => {
            message.style.display = "none";  // Hide it after a few seconds
        }, 2000);
    }, () => {
        const message = document.getElementById("copyMessage");
        message.innerText = "Failed to copy password.";
        message.style.color = "red";
        message.style.display = "block";  // Show error message
        setTimeout(() => {
            message.style.display = "none";  // Hide it after a few seconds
        }, 2000);
    });
}
