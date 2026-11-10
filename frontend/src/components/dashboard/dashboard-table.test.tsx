import { render, screen } from "@testing-library/react";
import { describe, expect, it } from "vitest";

import { DashboardTable } from "@/components/dashboard/dashboard-table";

describe("DashboardTable", () => {
  it("renders market asset rows", () => {
    render(
      <DashboardTable
        assets={[
          { asset: "BTC", price: 65000.25, youOwn: 0.8 },
          { asset: "ETH", price: 3500, youOwn: 4.25 },
        ]}
      />,
    );

    expect(screen.getByText("Dashboard")).toBeInTheDocument();
    expect(screen.getByText("BTC")).toBeInTheDocument();
    expect(screen.getByText("ETH")).toBeInTheDocument();
    expect(screen.getByText("0.8")).toBeInTheDocument();
  });
});