<script setup>
import kmap from "@/components/common/VKakaoMap.vue";
import PlanSideBar from "@/components/Plan/PlanSidebar.vue";
</script>

<template>
  <div>계획 등록 뷰</div>
  <div class="plan">
    <PlanSideBar />
    <kmap></kmap>
    <InsertSideBar />
  </div>
</template>

<style lang="scss" scoped>
.plan {
  display: flex;

  main {
    flex: 1 1 0;
    padding: 2rem;

    @media (max-width: 768px) {
      padding-left: 6rem;
    }
  }
}
</style>
