<script setup>
import kmap from "@/components/common/VKakaoMap.vue";
import TimeLine from "@/components/Plan/TimeLine.vue";
import InsertSideBar from "@/components/Plan/InsertSideBar.vue";
</script>

<template>
  <div>계획 등록 뷰</div>
  <div>
    <InsertSideBar></InsertSideBar>
    <kmap></kmap>
    <TimeLine></TimeLine>
  </div>
</template>

<style scoped>
div {
  display: flex;
}
</style>
