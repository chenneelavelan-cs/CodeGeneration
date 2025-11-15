const buttonEl = document.getElementById("myButton");

let clickCount = 0;

buttonEl.innerText = `Clicked ${clickCount} times`

function buttonClick(e) {
    clickCount += 1;
    console.log("clicked on button: ", e);
    console.log("Click count: ", clickCount);
    buttonEl.innerText = `Clicked ${clickCount} times`;
}

buttonEl.addEventListener("click", buttonClick);
