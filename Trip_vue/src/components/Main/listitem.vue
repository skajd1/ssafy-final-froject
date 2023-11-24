<script setup>
const props = defineProps({
  item: Object,
});
// console.log(props.item);
</script>

<template>
  <div class="item">
    <img v-if="item.firstImage" :src="item.firstImage" alt="사진" />
    <img v-else src="@/assets/logo0.svg" alt="사진" />
  </div>
</template>

<style scoped>
.item {
  min-width: 300px;
  height: 200px;
  background-color: var(--vt-c-bg);
  margin: 0 5px;
  margin-top: 1rem;
  margin-bottom: 1rem;
  text-align: center;
}
img {
  border-radius: 10px;
  width: 100%;
  height: 100%;

  box-shadow: 0 0 8px var(--main-color);
}
</style>
