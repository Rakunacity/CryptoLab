"use client";

import { useQuery } from "@tanstack/react-query";

import { getDashboardAssets } from "@/lib/api";
import { DashboardTable } from "@/components/dashboard/dashboard-table";

export function DashboardContent() {
  const { data, isLoading, isError } = useQuery({
    queryKey: ["dashboard-assets"],
    queryFn: getDashboardAssets,
  });

  if (isLoading) {
    return (
      <div className="rounded-[28px] border border-black/10 bg-white/80 p-10 text-sm text-slate-600 shadow-[0_24px_80px_-32px_rgba(15,23,42,0.45)]">
        Loading dashboard...
      </div>
    );
  }

  if (isError || !data) {
    return (
      <div className="rounded-[28px] border border-rose-200 bg-rose-50 p-10 text-sm text-rose-700 shadow-[0_24px_80px_-32px_rgba(15,23,42,0.25)]">
        Unable to load assets from the backend. Start Spring Boot on port 8080
        or set <code>NEXT_PUBLIC_API_BASE_URL</code>.
      </div>
    );
  }

  return <DashboardTable assets={data} />;
}