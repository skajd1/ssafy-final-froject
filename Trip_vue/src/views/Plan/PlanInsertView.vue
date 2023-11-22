<script setup>
import PlanMap from "@/components/Plan/PlanMap.vue";
import PlanSearchSideBar from "@/components/Plan/PlanSearchSidebar.vue";
import PlanInsertSideBar from "@/components/Plan/PlanInsertSideBar.vue";
</script>

<template>
  <div class="plan">
    <PlanSearchSideBar />
    <div class="mapbox">
      <PlanMap />
    </div>
    <div class="right-sidebar">
      <PlanInsertSideBar />
    </div>
  </div>
</template>

<style lang="scss" scoped>
.plan {
  display: flex;
}
.mapbox {
  width: 85%;
  height: 750px;
}
.right-sidebar {
  align-items: right;
  height: 743px;
  z-index: 5;
}
</style>
