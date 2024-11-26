const { Builder, By, Key, until } = require('selenium-webdriver');

(async function testRegistrationForm() {
  // WebDriver inicializálása (ChromeDriver-t használva)
  let driver = await new Builder().forBrowser('chrome').build();

  try {
    // Oldal betöltése (Add meg a saját elérési útvonaladat vagy URL-t)
    await driver.get('http://127.0.0.1:5500/index.html'); // Helyi Live Server használata esetén

    // 1. Ellenőrizd, hogy az oldal helyesen betöltődik
    let pageTitle = await driver.getTitle();
    if (pageTitle === "Webshop Regisztráció") {
      console.log("Oldal betöltve: Sikeres");
    } else {
      console.error("Oldal betöltve: Sikertelen");
    }

    // 2. Teszt: Űrlap helyes kitöltése és ellenőrzés
    await driver.findElement(By.id('name')).sendKeys('Teszt Felhasználó');
    await driver.findElement(By.id('email')).sendKeys('teszt@example.com');
    await driver.findElement(By.id('password')).sendKeys('teszt123');
    await driver.findElement(By.tagName('button')).click();

    // Várakozás a sikeres regisztrációs üzenet megjelenésére
    let resultText = await driver.wait(until.elementLocated(By.id('result')), 5000).getText();

    if (resultText === "Sikeres regisztráció!") {
      console.log("Űrlap teszt sikeres!");
    } else {
      console.error("Űrlap teszt sikertelen!");
    }

    // 3. Teszt: Kötelező mezők ellenőrzése
    await driver.navigate().refresh(); // Oldal újratöltése
    await driver.findElement(By.tagName('button')).click();

    let errorMessage = await driver.wait(until.elementLocated(By.id('result')), 5000).getText();

    if (errorMessage === "Minden mezőt ki kell tölteni!") {
      console.log("Kötelező mezők teszt sikeres!");
    } else {
      console.error("Kötelező mezők teszt sikertelen!");
    }
  } catch (error) {
    console.error("Hiba történt a teszt során:", error);
  } finally {
    // WebDriver leállítása
    await driver.quit();
  }
})();
