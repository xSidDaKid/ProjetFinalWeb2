/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
dropdownMenu = document.getElementById("a");
dropdownButton = document.getElementById("b");
console.log(dropdownButton);

if (dropdownButton) {
    console.log("asd");
  dropdownButton.addEventListener("click", () => {
    dropdownMenu.classList.toggle("show");
  });
}

