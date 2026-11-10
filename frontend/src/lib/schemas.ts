import { z } from "zod";

export const dashboardAssetSchema = z.object({
  asset: z.string().min(1),
  price: z.coerce.number().nonnegative(),
  youOwn: z.coerce.number().nonnegative(),
});

export const dashboardAssetsSchema = z.array(dashboardAssetSchema);

export type DashboardAsset = z.infer<typeof dashboardAssetSchema>;