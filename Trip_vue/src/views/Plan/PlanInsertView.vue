<script setup>
import kmap from "@/components/common/VKakaoMap.vue";
import PlanSearchSideBar from "@/components/Plan/PlanSearchSidebar.vue";
import PlanInsertSideBar from "@/components/Plan/PlanInsertSideBar.vue";
</script>

<template>
  <div>계획 등록 뷰</div>
  <div class="plan">
    <PlanSearchSideBar />
    <div class="mapbox">
      <kmap></kmap>
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
  height: 743px;
}
.right-sidebar {
  align-items: right;
  height: 743px;
}
</style>
