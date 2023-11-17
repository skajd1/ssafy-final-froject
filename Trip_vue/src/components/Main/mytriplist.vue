<script setup>
import listitem from "@/components/Main/ListItem.vue";
const item = 30;
// 임시 이미지
const img = "https://picsum.photos/800/400?random=";
</script>

<template>
  <div class="container">
    <h2>찜한 여행지</h2>
    <div class="itembox">
      <listitem :img="img + i" v-for="i in item"></listitem>
    </div>
  </div>
</template>

<style scoped>
.container {
  width: 80%;
  background-color: var(--vt-c-bg);
  color: var(--main-color);
  margin: 0 auto;
  margin-bottom: 1rem;
  padding-bottom: 2rem;
  border-radius: 10px;
}
/* 가로 스크롤바 */
.itembox {
  display: flex;
  overflow: auto;
  white-space: nowrap;
}
</style>
