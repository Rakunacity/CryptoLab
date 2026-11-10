import { expect, test } from "@playwright/test";

test("dashboard page renders heading", async ({ page }) => {
  await page.goto("/");

  await expect(
    page.getByRole("heading", {
      name: "Track market prices and your holdings in one focused view.",
    }),
  ).toBeVisible();
});