import { ArrowUpRight, DatabaseZap, Wallet } from "lucide-react";

import { DashboardContent } from "@/components/dashboard/dashboard-content";

export default function Home() {
  return (
    // brush up styles
    <main className="min-h-screen bg-[radial-gradient(circle_at_top_left,#fff1bf,transparent_22%),radial-gradient(circle_at_top_right,#ffd6b8,transparent_18%),linear-gradient(180deg,#fffdf7_0%,#f6efe1_48%,#efe3cf_100%)] px-6 py-10 text-slate-950 md:px-10 lg:px-14">
        <DashboardContent />
    </main>
  );
}
