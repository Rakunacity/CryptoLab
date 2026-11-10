import { TrendingUp } from "lucide-react";

import type { DashboardAsset } from "@/lib/schemas";
import { Badge } from "@/components/ui/badge";
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import {
  Table,
  TableBody,
  TableCell,
  TableHead,
  TableHeader,
  TableRow,
} from "@/components/ui/table";

function formatCurrency(value: number) {
  return new Intl.NumberFormat("en-US", {
    style: "currency",
    currency: "USD",
    minimumFractionDigits: 2,
    maximumFractionDigits: 2,
  }).format(value);
}

function formatUnits(value: number) {
  return new Intl.NumberFormat("en-US", {
    minimumFractionDigits: 0,
    maximumFractionDigits: 4,
  }).format(value);
}

export function DashboardTable({ assets }: { assets: DashboardAsset[] }) {
  return (
    <Card>
      <CardHeader>
        <Badge className="w-fit">Market Snapshot</Badge>
        <div className="flex flex-col gap-3 lg:flex-row lg:items-end lg:justify-between">
          <div className="space-y-2">
            <CardTitle>Dashboard</CardTitle>
            <CardDescription>
              Live market rows from Spring Boot, with your current in-memory
              holdings alongside each asset.
            </CardDescription>
          </div>
          <div className="inline-flex items-center gap-2 rounded-full bg-slate-950 px-4 py-2 text-sm font-medium text-white">
            <TrendingUp className="h-4 w-4" />
            {assets.length} tracked assets
          </div>
        </div>
      </CardHeader>
      <CardContent>
        <div className="overflow-hidden rounded-[22px] border border-black/10 bg-white">
          <Table>
            <TableHeader>
              <TableRow>
                <TableHead>Asset</TableHead>
                <TableHead className="text-right">Price</TableHead>
                <TableHead className="text-right">You own</TableHead>
              </TableRow>
            </TableHeader>
            <TableBody>
              {assets.map((asset) => (
                <TableRow key={asset.asset}>
                  <TableCell>
                    <div className="flex items-center gap-3">
                      <div className="flex h-11 w-11 items-center justify-center rounded-2xl bg-[linear-gradient(135deg,#f59e0b,#f97316)] text-sm font-semibold text-white shadow-lg shadow-amber-500/20">
                        {asset.asset.slice(0, 2)}
                      </div>
                      <div>
                        <div className="text-sm font-semibold tracking-[0.02em] text-slate-950">
                          {asset.asset}
                        </div>
                        <div className="text-xs uppercase tracking-[0.18em] text-slate-500">
                          Crypto asset
                        </div>
                      </div>
                    </div>
                  </TableCell>
                  <TableCell className="text-right font-medium text-slate-950">
                    {formatCurrency(asset.price)}
                  </TableCell>
                  <TableCell className="text-right text-slate-700">
                    {formatUnits(asset.youOwn)}
                  </TableCell>
                </TableRow>
              ))}
            </TableBody>
          </Table>
        </div>
      </CardContent>
    </Card>
  );
}